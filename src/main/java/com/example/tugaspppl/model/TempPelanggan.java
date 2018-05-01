package com.example.tugaspppl.model;

import java.util.Date;

public class TempPelanggan {
    private int idPelanggan;
    private String namaPelanggan;

    private String emailPelanggan;

    private String noIdentitasPelanggan;

    private String noTlpnPelanggan;

    private String alamatPelanggan;

    private int statusAktif;

    private String namaInstitusi;
    private int idUser;

    private String username;

    private String password;

    public TempPelanggan(){}
    public TempPelanggan(int idPelanggan, String namaPelanggan, String emailPelanggan, String noIdentitasPelanggan, String noTlpnPelanggan, String alamatPelanggan, int statusAktif, String namaInstitusi, int idUser, String username, String password) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.emailPelanggan = emailPelanggan;
        this.noIdentitasPelanggan = noIdentitasPelanggan;
        this.noTlpnPelanggan = noTlpnPelanggan;
        this.alamatPelanggan = alamatPelanggan;
        this.statusAktif = statusAktif;
        this.namaInstitusi = namaInstitusi;
        this.idUser = idUser;
        this.username = username;
        this.password = password;

    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getEmailPelanggan() {
        return emailPelanggan;
    }

    public void setEmailPelanggan(String emailPelanggan) {
        this.emailPelanggan = emailPelanggan;
    }

    public String getNoIdentitasPelanggan() {
        return noIdentitasPelanggan;
    }

    public void setNoIdentitasPelanggan(String noIdentitasPelanggan) {
        this.noIdentitasPelanggan = noIdentitasPelanggan;
    }

    public String getNoTlpnPelanggan() {
        return noTlpnPelanggan;
    }

    public void setNoTlpnPelanggan(String noTlpnPelanggan) {
        this.noTlpnPelanggan = noTlpnPelanggan;
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public void setAlamatPelanggan(String alamatPelanggan) {
        this.alamatPelanggan = alamatPelanggan;
    }

    public int getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(int statusAktif) {
        this.statusAktif = statusAktif;
    }

    public String getNamaInstitusi() {
        return namaInstitusi;
    }

    public void setNamaInstitusi(String namaInstitusi) {
        this.namaInstitusi = namaInstitusi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
