package com.example.financa.entities.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.id = :id")
    User findUserById(@Param("id") Long id);

    @Query( "SELECT u.id " +
            "FROM User u " +
            "WHERE u.email = :email " +
            "AND u.password = :password")
    Long loginUser(@Param("email") String email, @Param("password") String password);

    @Query( "SELECT u.id " +
            "FROM User u " +
            "WHERE u.email = :email")
    Long isUserExist(@Param("email") String email);

    @Query( "SELECT u.id " +
            "FROM User u " +
            "WHERE u.id = :id")
    Long isUserExist(@Param("id") Long id);

    @Query( "SELECT u " +
            "FROM User u " +
            "WHERE u.email = :email " +
            "AND u.password = :password")
    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
