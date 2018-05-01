package com.example.tugaspppl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name = "tbl_season")

public class Season {
    @Id
    @Column(name = "idSeason")
    private int idSeason;
    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Column(name = "namaSeason")
    @Size(max = 30)
    private String namaSeason;
    @Column(name = "persentase")
    private float persentase;
    @Column(name = "jenisPersentase")
    @Size(max = 20)
    private String jenisPersentase;
    @Column(name = "statusSeason")
    private int statusSeason;

    @ManyToOne
    @JoinColumn(name = "idCabang")
    public Cabang seasonCabangMap;
}
