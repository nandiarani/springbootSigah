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
@Table(name = "tbl_jeniskasur")
public class JenisKasur {
    @Id
    @Column(name = "idJenisKasur")
    private int idJenisKasur;
    @Column(name = "namaJenisKasur")
    @Size(max = 20)
    private String namaJenisKasur;

    @OneToMany(mappedBy = "kamarJenisKasurMap")
    private List<Kamar> kamars = new ArrayList<>();
}
