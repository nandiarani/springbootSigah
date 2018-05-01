package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.peran.PeranDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeranService {
    @Autowired
    private PeranDao peranDao;
}
