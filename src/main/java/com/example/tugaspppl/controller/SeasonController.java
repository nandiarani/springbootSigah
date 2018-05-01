package com.example.tugaspppl.controller;

import com.example.tugaspppl.model.Season;
import com.example.tugaspppl.model.TempPelanggan;
import com.example.tugaspppl.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@Controller
public class SeasonController {
    @Autowired
    private SeasonService seasonService;
    @RequestMapping(value = "/season",method = RequestMethod.GET)
    public String tampilSeluruhSeason(Model model){
        model = seasonService.getAllSeason(model);
        return "/admin/season";
    }

    @RequestMapping(value = "/tambahSeason", method = RequestMethod.POST)
    public String tambahSeason(@ModelAttribute("season")Season season, Model model)
    {
        System.out.println("kedua");
        return seasonService.save(model,season);
    }
    @RequestMapping(value = "/tambahSeason", method = RequestMethod.GET)
    public String manageTambahSeason(Model model)
    {
        System.out.println("pertama");
        model=seasonService.manageTambahSeason(model);
        return "/admin/tambahSeason";
    }
}
