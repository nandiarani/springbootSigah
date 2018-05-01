package com.example.tugaspppl.dao.pelanggan;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.Pelanggan;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class PelangganDaoImpl extends My_Connection implements PelangganDaoCustom {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<Pelanggan> getPelangganById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Pelanggan> result = em.createNativeQuery(
                "select * from tbl_pelanggan WHERE tbl_pelanggan.idPelanggan= " + id + "", Pelanggan.class).getResultList();
        return result;
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Pelanggan> result = em.createNativeQuery(
                "select * from tbl_pelanggan ", Pelanggan.class).getResultList();
        return result;
    }

    @Override
    public Pelanggan softDeletePelanggan(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Pelanggan result = em.find(Pelanggan.class, id);
        if (result.getStatusAktif() == 1)
            result.setStatusAktif(0);
        else if (result.getStatusAktif() == 0)
            result.setStatusAktif(1);
        em.getTransaction().commit();
        return result;
    }

    public List<Pelanggan> getPelangganByUsername(String username) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Pelanggan> result = em.createNativeQuery(
                "select * from tbl_pelanggan a join tbl_user b on a.idPelanggan=b.idPelanggan where lower(b.username) like lower('%\"+ username +\"%')", Pelanggan.class).getResultList();
        return result;
    }

    public int getIdPelangganByData(String nama, String email, String noIdentitas, String noTelepon, String alamat) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Pelanggan> result = em.createNativeQuery(
                "select a.idPelanggan from tbl_pelanggan a WHERE a.namaPelanggan like ("+nama+") AND a.alamatPelanggan like ("+alamat+") AND a.noIdentitasPelanggan like ("+noIdentitas+") AND a.noTlpnPelanggan like "+noTelepon+"", Pelanggan.class).getResultList();
        return result.get(0).getIdPelanggan();
    }
    @Autowired
    public int getIdNext(){
        String psql=" SELECT AUTO_INCREMENT\n" +
                "FROM information_schema.TABLES\n" +
                "WHERE TABLE_SCHEMA = \"sigah\"\n" +
                "AND TABLE_NAME = \"tbl_pelanggan\"";
        int idTemp=0;
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                while (resultSet.next())    {
                    idTemp = resultSet.getInt("auto_increment");
                }
            }
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return idTemp;
    }
    @Autowired
    public Date getDateToday(){
        String psql=" SELECT CURRENT_DATE";
        Date datetemp=new Date();
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                while (resultSet.next())    {
                    datetemp= resultSet.getDate("current_date");
                }
            }
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return datetemp;
    }

    @Override
    public void inputPelanggan(Pelanggan p){
        String query=" INSERT INTO tbl_pelanggan" +
                "(idPelanggan, idPeran, namaPelanggan, emailPelanggan, noIdentitasPelanggan, noTlpnPelanggan, " +
                "alamatPelanggan, namaInstitusi, statusAktif) " +
                "VALUES (NULL ,7,'"+p.getNamaPelanggan()+"','"+p.getEmailPelanggan()+"','"+p.getNoIdentitasPelanggan()+"','"+p.getNoTlpnPelanggan()+"'," +
                "'"+p.getAlamatPelanggan()+"','"+p.getNamaInstitusi()+"',1)";
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            statement.executeUpdate(query);
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
    }

}
