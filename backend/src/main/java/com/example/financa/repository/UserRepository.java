package com.example.financa.repository;

import com.example.financa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" SELECT u " +
            "FROM User u " +
            "WHERE u.id = :id")
    User findUserById(@Param("id") Long id);


}
