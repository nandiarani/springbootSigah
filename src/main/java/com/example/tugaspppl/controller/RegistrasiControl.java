package com.example.tugaspppl.controller;

import com.example.tugaspppl.model.TempPelanggan;
import com.example.tugaspppl.service.PelangganService;
import com.example.tugaspppl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
public class RegistrasiControl {
    @Autowired
    private PelangganService pelangganService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/"})
    public String mainPage() {

        return "index";
    }
    @RequestMapping(value = {"/index"})
    public String mainPageLogin() {

        return "index";
    }

    @RequestMapping(value = {"/loginpage"})
    public String loginpage(Model model) {
        System.out.println("pertama");
        model=userService.manageUserLogin(model);
        return "/customer/loginpage";
    }

    @RequestMapping(value = {"/registrasiPelangganEx"}, method = RequestMethod.GET)
    public String registrasipageEx(Model model) {
        System.out.println("kedua");
        model= pelangganService.manageTambahPelanggan(model);
        return "/customer/registrasiPelangganEx";
    }
    @RequestMapping(value = {"/registrasiPelanggan"}, method = RequestMethod.GET)
    public String registrasipage(Model model) {
        System.out.println("kedua");
        model= pelangganService.manageTambahPelanggan(model);
        return "/customer/registrasiPelanggan";
    }
    @RequestMapping(value = {"/registrasiPelanggan"}, method = RequestMethod.POST)
    public String registrasipageSave(@ModelAttribute("pelanggan")TempPelanggan temp,Model model) {
        System.out.println("masuk koq");
        System.out.println("ketiga");
        return  pelangganService.savePelanggan(model, temp);
    }

}



