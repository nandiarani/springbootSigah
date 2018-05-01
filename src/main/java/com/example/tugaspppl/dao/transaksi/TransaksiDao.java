package com.example.tugaspppl.dao.transaksi;

import com.example.tugaspppl.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiDao extends CrudRepository<Transaksi,Integer> {
}
