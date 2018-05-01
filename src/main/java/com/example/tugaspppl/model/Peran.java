package com.example.tugaspppl.model;

import lombok.*;
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
@Table(name = "tbl_peran")
public class Peran {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "idPeran")
    private int idPeran;
    @Column(name = "namaPeran")
    @Size(max = 20)
    private String namaPeran;
    @OneToMany(mappedBy = "pelangganPeranMap")
    private List<Pelanggan> pelanggans= new ArrayList<>();
    @OneToMany(mappedBy = "pegawaiPeranMap")
    private List<Pegawai> pegawais= new ArrayList<>();
    @OneToMany(mappedBy = "userPeranMap")
    private List<User> users=new ArrayList<>();

}
