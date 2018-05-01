package com.example.tugaspppl.dao.statusTransaksi;

import com.example.tugaspppl.model.StatusTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTransaksiDao extends CrudRepository<StatusTransaksi,Integer> {
}
