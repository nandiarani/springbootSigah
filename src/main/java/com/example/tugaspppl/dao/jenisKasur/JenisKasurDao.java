package com.example.tugaspppl.dao.jenisKasur;

import com.example.tugaspppl.model.JenisKasur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisKasurDao extends CrudRepository<JenisKasur,Integer> {
}
