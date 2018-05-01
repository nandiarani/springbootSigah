package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "tbl_transaksi")
public class Transaksi {
    @Id
    @Column(name = "idTransaksi")
    private int idTransaksi;
    @Column(name = "tanggalBayar")
    private Date tanggalBayar;
    @Column(name = "idInvoice")
    @Size(max = 11)
    private String idInvoice;

    @ManyToOne
    @JoinColumn(name = "idReservasi")
    private Reservasi transaksiReservasiMap;

    @OneToMany(mappedBy = "detilTransaksiTransaksiMap")
    private List<DetilTransaksi> detilTransaksis= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idStatusTransaksi")
    private StatusTransaksi transaksiStatusTransaksiMap;
    @ManyToOne
    @JoinColumn(name = "idPegawai")
    private Pegawai transaksiPegawaiMap;
}

