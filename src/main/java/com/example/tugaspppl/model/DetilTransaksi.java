package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_detiltransaksi")
public class DetilTransaksi {
    @Id
    @Column(name = "idDetilTransaksi")
    private int idDetilTransaksi;

    @ManyToOne
    @JoinColumn(name = "idKamar")
    private Kamar detilTransaksiKamarMap;
    @ManyToOne
    @JoinColumn(name = "idTransaksi")
    private Transaksi detilTransaksiTransaksiMap;
}
