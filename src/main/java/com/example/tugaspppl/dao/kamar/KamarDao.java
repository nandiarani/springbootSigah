package com.example.tugaspppl.dao.kamar;

import com.example.tugaspppl.model.Kamar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KamarDao extends CrudRepository<Kamar,Integer>,KamarDaoCustom {
    Kamar findByIdKamar(int id);
}
