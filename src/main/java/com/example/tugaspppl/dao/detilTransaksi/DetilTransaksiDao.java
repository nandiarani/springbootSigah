package com.example.tugaspppl.dao.detilTransaksi;

import com.example.tugaspppl.model.DetilTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetilTransaksiDao extends CrudRepository<DetilTransaksi,Integer> {
}
