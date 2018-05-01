package com.example.tugaspppl.dao.kamar;

import com.example.tugaspppl.dao.My_Connection;
import com.example.tugaspppl.model.Kamar;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class KamarDaoImpl extends My_Connection implements KamarDaoCustom{
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void softDelete(int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Kamar result = em.find(Kamar.class,id);
        if(result.getStatusKamar()==1)
            result.setStatusKamar(0);
        else if(result.getStatusKamar()==0)
            result.setStatusKamar(1);
        em.getTransaction().commit();
    }
}
