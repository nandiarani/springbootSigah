package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.pelanggan.PelangganDao;
import com.example.tugaspppl.dao.user.UserDao;
import com.example.tugaspppl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PelangganDao pelangganDao;

    public String loginService(User user){
        int cekada,cekaktif,idPeran;
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        cekada=1;
        //cekada=userDao.cekAdaUser(user);
        idPeran=userDao.cekPeranUser(user);
        cekaktif=userDao.cekKeaktifan(user,idPeran);
        System.out.println("id peran yang didapat = "+idPeran);
        if(cekada==1 && cekaktif==1){
            if (idPeran==1){ //corporate owner
                return "redirect:/indexCorporateOwner";
            }
            else if (idPeran==2){//General Manager
                return "redirect:/indexGM";
            }
            else if (idPeran==3){//Sales & Marketng
                return "redirect:/indexSM";
            }
            else if (idPeran==4){//Hotel Account
                return "redirect:/indexHA";
            }
            else if (idPeran==5){//Personel Manager
                return "redirect:/indexPM";
            }
            else if (idPeran==6){//Front Office
                return "redirect:/indexFO";
            }
            else if (idPeran==7){//Customer
                return "redirect:/indexCustomer";
            }
            else{
                System.out.println("ini aneh. perannya ga ada... cek database coy");
            }
        }
        else {
            //ga ada di db
        }
        return "redirect:/suksesRegistrasi";
    }

    public Model manageUserLogin(Model model){
        model.addAttribute("user",new User());
        return model;
    }

}
