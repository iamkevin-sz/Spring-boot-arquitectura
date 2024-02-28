package com.kevincode.data.mysql.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kevincode.data.mysql.entitites.UserMysqlEntity;

public interface UserMysqlRepository extends JpaRepository<UserMysqlEntity, Long>{
    Optional<UserMysqlEntity> findByUsername(String username);

    @Query("select u from UserMysqlEntity u where u.username = ?1")
    Optional<UserMysqlEntity> getName(String username);
}
