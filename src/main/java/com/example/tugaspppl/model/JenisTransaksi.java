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
@Table(name = "tbl_jenistransaksi")
public class JenisTransaksi {
    @Id
    @Column(name = "idJenisTransaksi")
    private int idJenisTransaksi;
    @Column(name = "jenisTransaksi")
    @Size(max = 8)
    private String jenisTransaksi;
    @Column(name = "noPemegangKartu")
    @Size(max = 12)
    private String noPemegangKartu;
    @Column(name = "namaPemegangKartu")
    @Size(max = 30)
    private String namaPemegangKartu;

    @OneToMany(mappedBy = "reservasiJenisTransaksiMap")
    private List<Reservasi> reservasis= new ArrayList<>();

}
