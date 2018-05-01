package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.pelanggan.PelangganDao;
import com.example.tugaspppl.dao.user.UserDao;
import com.example.tugaspppl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@Transactional
public class PelangganService {

    @Autowired
    private PelangganDao pelangganDao;
    @Autowired
    private UserDao userDao;

    public int simpanPelanggan(Pelanggan pelanggan){
        int idPelanggan;
        String nama, noIdentitas,noTlpn,alamat,email;

        pelanggan.setStatusAktif(1);
        pelangganDao.save(pelanggan);

        nama=pelanggan.getNamaPelanggan();
        noIdentitas=pelanggan.getNoIdentitasPelanggan();
        noTlpn=pelanggan.getNoTlpnPelanggan();
        alamat=pelanggan.getAlamatPelanggan();
        email=pelanggan.getEmailPelanggan();

        idPelanggan=pelangganDao.getIdPelangganByData(nama,email,noIdentitas,noTlpn,alamat);
        return idPelanggan;
    }
    public void softDeletePelanggan(int id){pelangganDao.softDeletePelanggan(id);}

    //Crud pelanggan
    public Model manageTambahPelanggan(Model model){
        model.addAttribute("pelanggan",new TempPelanggan());
        return model;
    }
    public String savePelanggan(Model model, TempPelanggan temp){
        Pelanggan pelanggan=new Pelanggan();
        User user=new User();
        user.setPassword(temp.getPassword());
        user.setUsername(temp.getUsername());
        user.setTanggalDaftar(pelangganDao.getDateToday());

        Peran peran = new Peran();
        peran.setIdPeran(7);
        Integer idnext;
        if(userDao.cekUsernameSama(user)==0) { //ga ada sama
            if (pelanggan.getIdPelanggan() == 0) {
                idnext = pelangganDao.getIdNext();
                pelanggan.setNamaPelanggan(temp.getNamaPelanggan());
                pelanggan.setAlamatPelanggan(temp.getAlamatPelanggan());
                pelanggan.setEmailPelanggan(temp.getEmailPelanggan());
                pelanggan.setNamaInstitusi("-");
                pelanggan.setNoIdentitasPelanggan(temp.getNoIdentitasPelanggan());
                pelanggan.setNoTlpnPelanggan(temp.getNoTlpnPelanggan());
                pelangganDao.inputPelanggan(pelanggan);

                userDao.inputUserPelanggan(user, idnext);
            }
        }
        else {
            System.out.println("dapet");
            return "redirect:/registrasiPelangganEx";
        }
        return "redirect:/suksesRegistrasi";
    }
    public Model getAllPelanggan(Model model){
        model.addAttribute("pelanggan",pelangganDao.getAllPelanggan());
        return model;
    }
}
