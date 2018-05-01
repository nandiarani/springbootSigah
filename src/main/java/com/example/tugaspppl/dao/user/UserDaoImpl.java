package com.example.tugaspppl.dao.user;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Null;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl extends My_Connection implements UserDaoCustom {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List<User> getUserByUsername(String username) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> result = em.createNativeQuery(
                "select * from tbl_user WHERE lower(tbl_user.username) like lower('%" + username + "%') ", User.class).getResultList();
        return result;
    }

    public List<User> getUserByIdPelanggan(int idPelanggan) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> result = em.createNativeQuery(
                "select * from tbl_user WHERE idPelanggan=" + idPelanggan + " AND idPeran=7", User.class).getResultList();
        return result;
    }

    public List<User> getUserByIdPegawai(int idPegawai) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<User> result = em.createNativeQuery(
                "select * from tbl_user WHERE idPegawai=" + idPegawai + " AND idPeran<>7", User.class).getResultList();
        return result;
    }
    @Override
    public void inputUserPelanggan(User u,int idnext){
        String query="INSERT INTO tbl_user(idUser, idPelanggan, idPegawai, idPeran, username, password, tanggalDaftar) VALUES " +
                "(NULL ,"+idnext+", NULL,7,'"+u.getUsername()+"','"+u.getPassword()+"','"+u.getTanggalDaftar()+"')";
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            statement.executeUpdate(query);
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
    }
    @Override
    public int cekUsernameSama(User user){
        String psql=" SELECT * FROM tbl_user WHERE username='"+user.getUsername()+"'";
        int cekAda=0;
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                cekAda=1;
            }
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return cekAda;
    }

    @Override
    public int cekPeranUser(User user){
        //String psql=" SELECT `idPeran` FROM `tbl_user` WHERE username='"+user.getUsername()+"' AND password='"+user.getPassword()+"'";
        String psql=" SELECT idPeran FROM tbl_user WHERE username='"+user.getUsername()+"' AND password='"+user.getPassword()+"'";
        int idPeran=0;
        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                while (resultSet.next())    {
                    idPeran = resultSet.getInt("idPeran");
                }
            }
            System.out.println("id peran:"+idPeran);
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return idPeran;

    }
    @Override
    public int cekKeaktifan(User user,int idPeran){
        String psql;
        int cekAktif=0;
        if (idPeran==7) {
            psql=" SELECT * FROM tbl_user u JOIN tbl_pelanggan p ON u.idPelanggan=p.idPelanggan WHERE u.username='"+user.getUsername()+"' AND  u.password='"+user.getPassword()+"' AND p.statusAktif=1";
        }
        else{
            psql=" SELECT * FROM tbl_user u JOIN tbl_pegawai p ON u.idPegawai=p.idPegawai WHERE u.username='"+user.getUsername()+"' AND  u.password='"+user.getPassword()+"' AND p.statusAktifPegawai=1";
        }

        try {
            this.makeConnection();
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(psql);
            if (resultSet != null)  {
                cekAktif=1;
            }
            System.out.println("yeyeyey");
            System.out.println("cek aktif:"+cekAktif);
            this.disconnect();
        } catch (Exception e) {
            System.out.println("Error while get nextval.."+e.toString());
        }
        return cekAktif;
    }
}
