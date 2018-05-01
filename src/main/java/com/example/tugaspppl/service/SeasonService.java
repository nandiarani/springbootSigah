package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.cabang.CabangDao;
import com.example.tugaspppl.dao.season.SeasonDao;
import com.example.tugaspppl.model.Cabang;
import com.example.tugaspppl.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class SeasonService {
    @Autowired
    private SeasonDao seasonDao;
    @Autowired
    private CabangDao cabangDao;
    public Model getAllSeason(Model model){
        model.addAttribute("season",seasonDao.findAll());
        return model;
    }
    public Model tampilanFormTambahSeason(Model model){
        model.addAttribute("season", new Season());
        model.addAttribute("cabang",cabangDao.findAll());
        return model;
    }
    public Model manageTambahSeason(Model model)
    {
        model.addAttribute("season", new Season());
        model.addAttribute("cabang", cabangDao.getAllCabang());
        return model;
    }

    public String save(Model model, Season season){
        if(season.getStatusSeason()==0){
            season.setStatusSeason(1);
        }
        seasonDao.save(season);
        return "redirect:/season";
    }

}
