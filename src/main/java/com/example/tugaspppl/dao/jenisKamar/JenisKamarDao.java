package com.example.tugaspppl.dao.jenisKamar;

import com.example.tugaspppl.model.JenisKamar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisKamarDao extends CrudRepository<JenisKamar,Integer>, JenisKamarDaoCustom {
    JenisKamar findByIdJenisKamar(int id);
}
