package com.example.tugaspppl.dao.detilFasilitas;

import com.example.tugaspppl.model.DetilFasilitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetilFasilitasDao extends CrudRepository<DetilFasilitas,Integer> {
}
