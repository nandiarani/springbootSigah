package com.example.tugaspppl.model;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_pelanggan")

public class Pelanggan {


    public Pelanggan(@Size(max = 30) String namaPelanggan, @Size(max = 40) String emailPelanggan, @Size(max = 20) String noIdentitasPelanggan, @Size(max = 12) String noTlpnPelanggan, @Size(max = 40) String alamatPelanggan, @Size(max = 30) String namaInstitusi) {
        this.namaPelanggan = namaPelanggan;
        this.emailPelanggan = emailPelanggan;
        this.noIdentitasPelanggan = noIdentitasPelanggan;
        this.noTlpnPelanggan = noTlpnPelanggan;
        this.alamatPelanggan = alamatPelanggan;
        this.namaInstitusi = namaInstitusi;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "idPelanggan")
    private int idPelanggan;
    @Column(name = "namaPelanggan")
    @Size(max = 30)
    private String namaPelanggan;
    @Column(name = "emailPelanggan")
    @Size(max = 40)
    private String emailPelanggan;
    @Column(name = "noIdentitasPelanggan")
    @Size(max = 20)
    private String noIdentitasPelanggan;
    @Column(name = "noTlpnPelanggan")
    @Size(max = 12)
    private String noTlpnPelanggan;
    @Column(name = "alamatPelanggan")
    @Size(max = 40)
    private String alamatPelanggan;
    @Column(name = "statusAktif")
    private int statusAktif;
    @Column(name = "namaInstitusi")
    @Size(max = 30)
    private String namaInstitusi;

    @ManyToOne
    @JoinColumn(name = "idPeran", insertable = true, updatable = true)
    private Peran pelangganPeranMap;

    @OneToMany(mappedBy = "userPelangganMap")
    private List<User> users= new ArrayList<>();
    @OneToMany(mappedBy = "reservasiPelangganMap")
    private List<Reservasi> reservasis= new ArrayList<>();
}
