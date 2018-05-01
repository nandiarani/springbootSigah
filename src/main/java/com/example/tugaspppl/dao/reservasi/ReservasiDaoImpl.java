package com.example.tugaspppl.dao.reservasi;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservasiDaoImpl extends My_Connection implements ReservasiDaoCustom {


    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String generateIDBooking() {
        String psql=" SELECT CONCAT(\"P\", \n" +
                "              DATE_FORMAT(CURRENT_DATE(),'%d'), \n" +
                "              DATE_FORMAT(CURRENT_DATE(),'%m'),\n" +
                "              DATE_FORMAT(CURRENT_DATE(),'%y'),\n" +
                "              \"-\",\n" +
                "              COUNT(idReservasi)+1) \n" +
                " AS ConcatedString FROM tbl_reservasi";
        String idReservasiGenerated= "";
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                while (resultSet.next())    {
                    System.out.println(idReservasiGenerated);
                    idReservasiGenerated=resultSet.getString("ConcatedString");
                }
            }
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return idReservasiGenerated;
    }
    @Override
    public List<Kamar> cariKamarTersedia(TempReservasi tempReservasi) {
        List<Kamar> kamarList= new ArrayList();
        String psql=
                "SELECT tk.idKamar, tk.idCabang, tk.idJenisKamar, tk.idJenisKasur, tk.idKamarFormated, tk.lantai, tk.nomorKamar, tk.statusMerokok, tk.statusKamar, tc.idCabang, tc.namaKotaCabang, tj.idJenisKamar, tj.namaJenisKamar, tj.tarifKamar, tj.luas, tj.kapasitas, tj.fasilitasKamar, tj.gambarKamar, tj2.idJenisKasur, tj2.namaJenisKasur " +
                        "FROM tbl_kamar tk JOIN tbl_cabang tc on tk.idCabang=tc.idCabang JOIN tbl_jeniskamar tj ON tk.idJenisKamar = tj.idJenisKamar JOIN tbl_jeniskasur tj2 ON tk.idJenisKasur = tj2.idJenisKasur " +
                        "where tc.namaKotaCabang='"+tempReservasi.getCabang()+"' AND tk.idKamar not in " +
                        "(SELECT tt.idKamar FROM tbl_detiltransaksi tt join tbl_transaksi ttrans on tt.idTransaksi=ttrans.idTransaksi join tbl_reservasi tres on tres.idReservasi=ttrans.idReservasi JOIN tbl_kamar tk on tk.idKamar=tt.idKamar join tbl_cabang tc on tc.idCabang=tk.idCabang " +
                        " WHERE (SELECT tbl_reservasi.tanggalCheckIn from tbl_reservasi WHERE tbl_reservasi.idReservasi='"+tempReservasi.getIdReservasi()+"') BETWEEN tres.tanggalCheckIn AND tres.tanggalCheckOut) ORDER BY tk.nomorKamar";
        try {
            this.makeConnection();
            System.out.println(psql);
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                while (resultSet.next())    {
                    Kamar kamar= new Kamar();
                    Cabang cabang= new Cabang();
                    JenisKamar jenisKamar= new JenisKamar();
                    JenisKasur jenisKasur= new JenisKasur();

                    kamar.setIdKamar(resultSet.getInt("tk.idKamar"));
                    kamar.setIdKamarFormated(resultSet.getString("tk.idKamarFormated"));
                    kamar.setLantai(resultSet.getInt("tk.lantai"));
                    kamar.setNomorKamar(resultSet.getInt("tk.nomorKamar"));
                    kamar.setStatusMerokok(resultSet.getInt("tk.statusMerokok"));
                    kamar.setStatusKamar(resultSet.getInt("tk.statusKamar"));

                    kamar.setKamarCabangMap(cabang);
                    kamar.setKamarJenisKamarMap(jenisKamar);
                    kamar.setKamarJenisKasurMap(jenisKasur);

                    kamar.getKamarCabangMap().setIdCabang(resultSet.getInt("tk.idCabang"));
                    kamar.getKamarCabangMap().setNamaKotaCabang(resultSet.getString("tc.namaKotaCabang"));

                    kamar.getKamarJenisKamarMap().setIdJenisKamar(resultSet.getInt("tk.idJenisKamar"));
                    kamar.getKamarJenisKamarMap().setNamaJenisKamar(resultSet.getString("tj.namaJenisKamar"));
                    kamar.getKamarJenisKamarMap().setTarifKamar(resultSet.getInt("tj.tarifKamar"));
                    kamar.getKamarJenisKamarMap().setLuas(resultSet.getInt("tj.luas"));
                    kamar.getKamarJenisKamarMap().setKapasitas(resultSet.getInt("tj.kapasitas"));
                    kamar.getKamarJenisKamarMap().setFasilitasKamar(resultSet.getString("tj.fasilitasKamar"));
                    kamar.getKamarJenisKamarMap().setGambarKamar(resultSet.getString("tj.gambarKamar"));

                    kamar.getKamarJenisKasurMap().setIdJenisKasur(resultSet.getInt("tk.idJeniskasur"));
                    kamar.getKamarJenisKasurMap().setNamaJenisKasur(resultSet.getString("tj2.namaJenisKasur"));

                    kamarList.add(kamar);
                }
            }
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return kamarList;
    }
}
