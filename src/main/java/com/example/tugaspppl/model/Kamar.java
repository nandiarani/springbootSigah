package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "tbl_kamar")
public class Kamar {
    @Id
    @Column(name = "idKamar")
    private int idKamar;
    @Column(name = "idKamarFormated")
    @Size(max = 10)
    private String idKamarFormated;
    @Column(name = "lantai")
    private int lantai;
    @Column(name = "nomorKamar")
    private int nomorKamar;
    @Column(name = "statusMerokok")
    private int statusMerokok;
    @Column(name = "statusKamar")
    private int statusKamar;


    @ManyToOne
    @JoinColumn(name = "idCabang")
    private Cabang kamarCabangMap;
    @ManyToOne
    @JoinColumn(name = "idJenisKasur")
    private JenisKasur kamarJenisKasurMap;
    @ManyToOne
    @JoinColumn(name = "idJenisKamar")
    private JenisKamar kamarJenisKamarMap;
    @OneToMany(mappedBy = "detilTransaksiKamarMap")
    private List<DetilTransaksi> detilTransaksis=new ArrayList<>();
}
