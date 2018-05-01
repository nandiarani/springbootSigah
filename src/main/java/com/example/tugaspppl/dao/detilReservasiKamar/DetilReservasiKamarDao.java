package com.example.tugaspppl.dao.detilReservasiKamar;

import com.example.tugaspppl.model.DetilReservasiKamar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetilReservasiKamarDao extends CrudRepository<DetilReservasiKamar,Integer> {
}
