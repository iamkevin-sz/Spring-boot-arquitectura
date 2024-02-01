package com.kevincode.data.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevincode.data.mysql.entitites.CourseMysqlEntity;

public interface CourseMysqlRepository extends JpaRepository<CourseMysqlEntity, Long>{
    
}
