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
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "tbl_cabang")
public class Cabang {
    @Id
    @Column(name = "idCabang")
    private int idCabang;
    @Column(name = "namaKotaCabang")
    @Size(max = 20)
    private String namaKotaCabang;

    @OneToMany(mappedBy = "seasonCabangMap")
    private List<Season> seasons=new ArrayList<>();
    @OneToMany(mappedBy = "kamarCabangMap")
    private List<Kamar> kamars=new ArrayList<>();
    @OneToMany(mappedBy = "pegawaiCabangMap")
    private List<Pegawai> pegawais= new ArrayList<>();

}
