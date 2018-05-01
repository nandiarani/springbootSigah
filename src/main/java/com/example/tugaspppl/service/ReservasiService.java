package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.jenisKamar.JenisKamarDao;
import com.example.tugaspppl.dao.kamar.KamarDao;
import com.example.tugaspppl.dao.pelanggan.PelangganDao;
import com.example.tugaspppl.dao.reservasi.ReservasiDao;
import com.example.tugaspppl.model.Kamar;
import com.example.tugaspppl.model.Pelanggan;
import com.example.tugaspppl.model.Reservasi;
import com.example.tugaspppl.model.TempReservasi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservasiService {
    @Autowired
    private JenisKamarDao jenisKamarDao;
    @Autowired
    private Kamar kamar;
    @Autowired
    private Pelanggan pelanggan;
    @Autowired
    private ReservasiDao reservasiDao;
    @Autowired
    private PelangganDao pelangganDao;
    @Autowired
    private KamarDao kamarDao;

    public Model manageInputReservasi(Model model){
        TempReservasi reservasi= new TempReservasi();
        reservasi.setIdReservasi(reservasiDao.generateIDBooking());
        model.addAttribute("reservasi", reservasi);
        return model;
    }
    public Model managePilihKamar(TempReservasi tempReservasi, Model model){
        System.out.println("woiyooo");
        Reservasi r= new Reservasi();
        r.setIdReservasi(tempReservasi.getIdReservasi());
        r.setJumlahDewasa(tempReservasi.getJumlahDewasa());
        r.setJumlahAnakanak(tempReservasi.getJumlahAnakanak());
        r.setJenisReservasi("P");
        r.setStatusPembayaran(0);
        r.setTanggalCheckIn(tempReservasi.getTanggalCheckIn());
        r.setTanggalCheckOut(tempReservasi.getTanggalCheckOut());
        r.setTanggalReservasi(pelangganDao.getDateToday());
        r.setTotalPembayaran(0);
        r.setStatusReservasi(1);
        tempReservasi.setTanggalReservasi(pelangganDao.getDateToday());
        System.out.println(r.getTanggalCheckIn());
        System.out.println(r.getTanggalCheckOut());
        reservasiDao.save(r);
        System.out.println("done here 1");
        model.addAttribute("kamars",reservasiDao.cariKamarTersedia(tempReservasi));
        System.out.println("done here 2");
        return model;
    }
    public Model initKamarDipilih(Model model){
        System.out.println("init kamar terpilih");
        model.addAttribute("kamarTerpilih",new ArrayList<Kamar>());
        return model;
    }
    public Model tampilDetilKamar(Model model,int id){
        model.addAttribute("kamar",kamarDao.findByIdKamar(id));
        return model;
    }
    public void tambahPilihKamar(int idKamar,ArrayList<Kamar> kamars,ArrayList<Kamar> kamarTerpilih){
        Kamar kamar;
        System.out.println("masuk service tambah pilih kamar");
        kamar=kamarDao.findByIdKamar(idKamar);

        //sout kamar
        System.out.println(kamar.getIdKamar());
        System.out.println(kamar.getIdKamarFormated());
        System.out.println(kamar.getNomorKamar());
        System.out.println(kamar.getKamarJenisKamarMap().getNamaJenisKamar());

        System.out.println("find kamar by id Kamar");
        kamarTerpilih.add(kamar);
        System.out.println("masukin kamar ke kamar terpilih");

        ///get index pake perulangan
        int indexKamars=-1;
        System.out.println(kamars.size());
        for(int i=0;i<kamars.size();i++){
            System.out.println("test");
            System.out.println(kamars.get(i).getIdKamarFormated());
            if(kamars.get(i).getIdKamar()==kamar.getIdKamar()){
                System.out.println("dapet");
                indexKamars=i;
                break;
            }
        }

        System.out.println(indexKamars+"=index kamar yang mau dihapus");
        kamars.remove(indexKamars);
        System.out.println("kamar berhasil dihapus dengan index "+indexKamars);
    }

    public void hapusPilihKamar(int id,ArrayList<Kamar> kamars,ArrayList<Kamar> kamarTerpilih){
        Kamar kamar;
        int indexKamars;
        kamar=kamarDao.findByIdKamar(id);
        kamars.add(kamar);

        indexKamars=kamarTerpilih.indexOf(kamar);
        kamarTerpilih.remove(indexKamars);
    }


}
