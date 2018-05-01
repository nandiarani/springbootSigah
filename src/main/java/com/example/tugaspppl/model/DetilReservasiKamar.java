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
@Table(name = "tbl_detilreservasikamar")
public class DetilReservasiKamar {
    @Id
    @Column(name = "idDetilReservasi")
    private int idDetilReservasi;
    @Column(name = "jumlahKamar")
    private int jumlahKamar;
    @Column(name = "subtotalReservasiKamar")
    private double subtotalReservasiKamar;
    @ManyToOne
    @JoinColumn(name = "idReservasi")
    private Reservasi detilReservasiKamarReservasiMap;
    @ManyToOne
    @JoinColumn(name = "idJenisKamar")
    private JenisKamar detilReservasiKamarJenisKamarMap;
}
