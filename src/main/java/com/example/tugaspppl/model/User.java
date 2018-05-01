package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
@Table(name = "tbl_user")
public class User {

    public User(@Size(max = 10) String username, @Size(max = 10) String password, Date tanggalDaftar) {
        this.username = username;
        this.password = password;
        this.tanggalDaftar = tanggalDaftar;
    }

    public User(@Size(max = 10) String username, @Size(max = 10) String password){
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "username")
    @Size(max = 10)
    private String username;
    @Column(name = "password")
    @Size(max = 10)
    private String password;
    @Column(name = "tanggalDaftar")
    private Date tanggalDaftar;

    @ManyToOne
    @JoinColumn(name = "idPelanggan", insertable = true, updatable = true)
    private Pelanggan userPelangganMap;
    @ManyToOne
    @JoinColumn(name = "idPegawai", insertable = true, updatable = true)
    private Pegawai userPegawaiMap;
    @ManyToOne
    @JoinColumn(name = "idPeran", insertable = true, updatable = true)
    private Peran userPeranMap;

}
