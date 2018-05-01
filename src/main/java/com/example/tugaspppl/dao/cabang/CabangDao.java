package com.example.tugaspppl.dao.cabang;

import com.example.tugaspppl.model.Cabang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface CabangDao extends CrudRepository<Cabang,Integer>, CabangDaoCustom {

}
