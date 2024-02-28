package com.kevincode.domain.repositories;

import com.kevincode.domain.models.UserModel;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDomainRepository extends CrudRepository<UserModel> {

    Optional<UserModel> findByUsername(String username);

    @Query("select u from UserModel u where u.username = ?1")
    Optional<UserModel> getName(String username);
}
