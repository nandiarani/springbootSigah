package com.example.tugaspppl.dao.jenisTransaksi;

import com.example.tugaspppl.model.JenisTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisTransaksiDao extends CrudRepository<JenisTransaksi,Integer> {
}
