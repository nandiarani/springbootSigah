package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_detilfasilitas")
public class DetilFasilitas {
    @Id
    @Column(name = "idPermintaanKhusus")
    private int idPermintaanKhusus;
    @Column(name = "jumlah")
    private int jumlah;
    @Column(name = "subtotalPermintaanKhusus")
    private double subtotalPermintaanKhusus;

    @ManyToOne
    @JoinColumn(name = "idFasilitas")
    private Fasilitas detilFasilitasFasilitasMap;
    @ManyToOne
    @JoinColumn(name = "idReservasi")
    private Reservasi detilFasilitasReservasiMap;


}
