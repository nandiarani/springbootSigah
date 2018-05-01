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
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_pegawai")
public class Pegawai {
    @Id
    @Column(name = "idPegawai")
    private int idPegawai;
    @Column(name = "namaPegawai")
    @Size(max = 30)
    private String namaPegawai;
    @Column(name = "alamatPegawai")
    @Size(max = 40)
    private String alamatPegawai;
    @Column(name = "emailPegawai")
    @Size(max = 40)
    private String emailPegawai;
    @Column(name = "statusAktifPegawai")
    private int statusAktifPegawai;

    @ManyToOne
    @JoinColumn(name = "idPeran")
    private Peran pegawaiPeranMap;
    @ManyToOne
    @JoinColumn(name = "idCabang")
    private Cabang pegawaiCabangMap;
    @OneToMany(mappedBy = "userPegawaiMap")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "transaksiPegawaiMap")
    private List<Transaksi> transaksis= new ArrayList<>();
    @OneToMany (mappedBy = "reservasiPegawaiMap")
    private List<Reservasi> reservasis= new ArrayList<>();


}
