package com.example.tugaspppl.dao.season;

import com.example.tugaspppl.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonDao extends CrudRepository<Season,Integer>,SeasonDaoCustom {
}
