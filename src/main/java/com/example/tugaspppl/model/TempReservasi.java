package com.example.tugaspppl.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TempReservasi {
    private String idReservasi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalReservasi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalCheckIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalCheckOut;
    private int jumlahDewasa;
    private int jumlahAnakanak;
    private double totalPembayaran;
    private int statusPembayaran;
    private String jenisReservasi;
    private int statusReservasi;


    private String cabang;
    public TempReservasi(){}

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getIdReservasi() {
        return idReservasi;
    }

    public void setIdReservasi(String idReservasi) {
        this.idReservasi = idReservasi;
    }

    public Date getTanggalReservasi() {
        return tanggalReservasi;
    }

    public void setTanggalReservasi(Date tanggalReservasi) {
        this.tanggalReservasi = tanggalReservasi;
    }

    public Date getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(Date tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public Date getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckOut(Date tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public int getJumlahDewasa() {
        return jumlahDewasa;
    }

    public void setJumlahDewasa(int jumlahDewasa) {
        this.jumlahDewasa = jumlahDewasa;
    }

    public int getJumlahAnakanak() {
        return jumlahAnakanak;
    }

    public void setJumlahAnakanak(int jumlahAnakanak) {
        this.jumlahAnakanak = jumlahAnakanak;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public int getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(int statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public String getJenisReservasi() {
        return jenisReservasi;
    }

    public void setJenisReservasi(String jenisReservasi) {
        this.jenisReservasi = jenisReservasi;
    }

    public int getStatusReservasi() {
        return statusReservasi;
    }

    public void setStatusReservasi(int statusReservasi) {
        this.statusReservasi = statusReservasi;
    }

}
