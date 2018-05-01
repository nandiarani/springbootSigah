package com.example.tugaspppl.controller;

import com.example.tugaspppl.model.Kamar;
import com.example.tugaspppl.model.TempReservasi;
import com.example.tugaspppl.service.ReservasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@Component
public class ReservasiControl {
    @Autowired
    public ReservasiService reservasiService;

    @RequestMapping(value = "/reservasiKamar", method = RequestMethod.GET)
    public String formReservasiKamar(Model model){
        System.out.println("masuk 1");
        model=reservasiService.manageInputReservasi(model);
        System.out.println("masuk 2");
        return "/customer/reservasiKamar";
    }
    @RequestMapping(value = "/pilihKamar",method = {RequestMethod.GET, RequestMethod.POST})
    public String formPilihKamar(@ModelAttribute("reservasi")TempReservasi tempReservasi, Model model1, Model model2){
        System.out.println("masuk 3");
        model1=reservasiService.managePilihKamar(tempReservasi,model1);
        model2=reservasiService.initKamarDipilih(model2);
        System.out.println("masuk 4");
        return "/customer/pilihKamar";
    }
    ///////////////for modal
    @RequestMapping(value = "/kamar/{id}")
    public String tampilDetilForReservasi(@PathVariable int id,Model model){
        reservasiService.tampilDetilKamar(model,id);
        return "/customer/pilihKamar :: modalContents";
    }

    @RequestMapping(value = "/tambahPilihKamar/{id}")
    public String tambahPilihKamar(@PathVariable int id, @ModelAttribute("kamars")ArrayList<Kamar> kamars, @ModelAttribute("kamarTerpilih")ArrayList<Kamar> kamarTerpilih){
        System.out.println("tes tambah pilih kamar");
        reservasiService.tambahPilihKamar(id,kamars,kamarTerpilih);
        System.out.println("tes tambah pilih kamar");
        return "/customer/pilihKamar";
    }
    @RequestMapping(value = "/hapusPilihKamar/{id}")
    public String hapusPilihKamar(@PathVariable int id,@ModelAttribute("kamars")ArrayList<Kamar> kamars, @ModelAttribute("kamarTerpilih")ArrayList<Kamar> kamarTerpilih){
        System.out.println("tes hapus pilih kamar");
        reservasiService.hapusPilihKamar(id,kamars,kamarTerpilih);
        System.out.println("tes hapus pilih kamar");
        return "/customer/pilihKamar";
    }


}
