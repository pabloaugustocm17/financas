package com.example.financa.repository;

import com.example.financa.entities.TokenUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenUser, Integer> {
}
