package com.example.tugaspppl.dao.pelanggan;

import com.example.tugaspppl.model.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface PelangganDao extends CrudRepository<Pelanggan,Integer>, PelangganDaoCustom{

}
