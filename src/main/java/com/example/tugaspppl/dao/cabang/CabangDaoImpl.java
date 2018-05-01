package com.example.tugaspppl.dao.cabang;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.Cabang;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CabangDaoImpl extends My_Connection implements CabangDaoCustom {
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    public List<Cabang> getAllCabang(){
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Cabang> result = em.createNativeQuery(
                "SELECT * from tbl_cabang",Cabang.class).getResultList();
        return result;
    }
}
