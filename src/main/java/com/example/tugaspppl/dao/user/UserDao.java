package com.example.tugaspppl.dao.user;

import com.example.tugaspppl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Integer>,UserDaoCustom{
}
