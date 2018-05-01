package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "tbl_reservasi")
public class Reservasi {
    @Id
    @Column(name = "idReservasi")
    @Size(max = 11)
    private String idReservasi;
    @Column(name = "tanggalReservasi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalReservasi;
    @Column(name = "tanggalCheckIn")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalCheckIn;
    @Column(name = "tanggalCheckOut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalCheckOut;
    @Column(name = "jumlahDewasa")
    private int jumlahDewasa;
    @Column(name = "jumlahAnakanak")
    private int jumlahAnakanak;
    @Column(name = "totalPembayaran")
    private double totalPembayaran;
    @Column(name = "statusPembayaran")
    private int statusPembayaran;
    @Column(name = "jenisReservasi")
    @Size(max = 1)
    private String jenisReservasi;
    @Column(name = "statusReservasi")
    private int statusReservasi;

    @OneToMany(mappedBy = "detilFasilitasReservasiMap")
    private List<DetilFasilitas> detilFasilitas= new ArrayList<>();
    @OneToMany(mappedBy = "detilReservasiKamarReservasiMap")
    private List<DetilReservasiKamar> detilReservasiKamars= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idJenisTransaksi")
    private JenisTransaksi reservasiJenisTransaksiMap;

    @OneToMany (mappedBy = "transaksiReservasiMap")
    private List<Transaksi> transaksis= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idPelanggan")
    private Pelanggan reservasiPelangganMap;
    @ManyToOne
    @JoinColumn(name = "idPegawai")
    private Pegawai reservasiPegawaiMap;
}
