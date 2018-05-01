package com.example.tugaspppl.dao.peran;

import com.example.tugaspppl.model.Peran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeranDao extends CrudRepository<Peran,Integer> {
}
