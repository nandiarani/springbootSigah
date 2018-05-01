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
@Table(name = "tbl_fasilitas")
public class Fasilitas {

    @Id
    @Column(name = "idFasilitas")
    private int idFasilitas;
    @Column(name = "namaFasilitas")
    @Size(max=30)
    private String namaFasilitas;
    @Column(name = "tarifFasilitas")
    private double tarifFasilitas;

    @OneToMany(mappedBy = "detilFasilitasFasilitasMap")
    private List<DetilFasilitas> detilFasilitas= new ArrayList<>();

}
