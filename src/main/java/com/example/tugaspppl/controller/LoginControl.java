package com.example.tugaspppl.controller;

import com.example.tugaspppl.model.User;
import com.example.tugaspppl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class LoginControl {
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/indexCorporateOwner"})
    public String indexCorporateOwner() {

        return "indexCorporateOwner";
    }

    @RequestMapping(value = {"/indexCustomer"})
    public String indexCustomer() {

        return "indexCustomer";
    }

    @RequestMapping(value = {"/indexFO"})
    public String indexFO() {

        return "indexFO";
    }

    @RequestMapping(value = {"/indexGM"})
    public String indexGM() {

        return "indexGM";
    }

    @RequestMapping(value = {"/indexHA"})
    public String indexHA() {

        return "indexHA";
    }

    @RequestMapping(value = {"/indexPM"})
    public String indexPM() {

        return "indexPM";
    }

    @RequestMapping(value = {"/indexSM"})
    public String indexSM() {

        return "indexSM";
    }
}
