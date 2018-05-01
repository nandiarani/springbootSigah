package com.example.tugaspppl.dao.fasilitas;

import com.example.tugaspppl.model.Fasilitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FasilitasDao extends CrudRepository<Fasilitas,Integer>,FasilitasDaoCustom {
    Fasilitas findByIdFasilitas(int id);
}
