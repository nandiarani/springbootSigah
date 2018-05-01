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
@Table(name = "tbl_statustransaksi")
public class StatusTransaksi {
    @Id
    @Column(name = "idStatusTransaksi")
    private int idStatusTransaksi;
    @Column(name = "statusTransaksi")
    @Size(max = 20)
    private String statusTransaksi;

    @OneToMany(mappedBy = "transaksiStatusTransaksiMap")
    private List<Transaksi> transaksis= new ArrayList<>();

}
