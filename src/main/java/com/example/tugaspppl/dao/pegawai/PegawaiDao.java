package com.example.tugaspppl.dao.pegawai;

import com.example.tugaspppl.model.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiDao extends CrudRepository<Pegawai,Integer> {
}
