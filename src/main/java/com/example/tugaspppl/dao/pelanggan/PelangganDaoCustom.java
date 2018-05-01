package com.example.tugaspppl.dao.pelanggan;

import com.example.tugaspppl.model.Pelanggan;
import com.example.tugaspppl.model.User;

import java.util.Date;
import java.util.List;

public interface PelangganDaoCustom {
    List<Pelanggan> getPelangganById(int id);
    List<Pelanggan> getAllPelanggan();
    Pelanggan softDeletePelanggan(int id);
    List<Pelanggan> getPelangganByUsername(String username);
    int getIdPelangganByData(String nama, String email, String noIdentitas, String noTelepon, String alamat);
    int getIdNext();
    Date getDateToday();
    void inputPelanggan(Pelanggan p);
}
