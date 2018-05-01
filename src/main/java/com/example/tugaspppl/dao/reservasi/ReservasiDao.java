package com.example.tugaspppl.dao.reservasi;

import com.example.tugaspppl.model.Reservasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasiDao extends CrudRepository<Reservasi,String>,ReservasiDaoCustom {
}
