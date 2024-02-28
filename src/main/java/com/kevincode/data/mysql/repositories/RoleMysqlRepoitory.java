package com.kevincode.data.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevincode.data.mysql.entitites.RoleMysqlEntity;

public interface RoleMysqlRepoitory extends JpaRepository<RoleMysqlEntity, Long>{
    
}
