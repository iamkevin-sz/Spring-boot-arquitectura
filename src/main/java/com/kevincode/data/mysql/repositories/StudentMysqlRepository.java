package com.kevincode.data.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevincode.data.mysql.entitites.StudentMysqlEntity;

public interface StudentMysqlRepository extends JpaRepository<StudentMysqlEntity, Long>{

}
    

