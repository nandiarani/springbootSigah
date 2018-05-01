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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_jeniskamar")
public class JenisKamar {
    @Id
    @Column(name = "idJenisKamar")
    private int idJenisKamar;
    @Column(name = "namaJenisKamar")
    private String namaJenisKamar;
    @Column(name = "tarifKamar")
    private double tarifKamar;
    @Column(name = "luas")
    private float luas;
    @Column(name = "kapasitas")
    private int kapasitas;
    @Column(name = "fasilitasKamar")
    @Size(max = 255)
    private String fasilitasKamar;
    @Column(name = "gambarKamar")
    @Size(max = 1024)
    private String gambarKamar;

    @OneToMany(mappedBy = "kamarJenisKamarMap")
    private List<Kamar> kamars= new ArrayList<>();
    @OneToMany(mappedBy = "detilReservasiKamarJenisKamarMap")
    private List<DetilReservasiKamar> detilReservasiKamars= new ArrayList<>();
}
