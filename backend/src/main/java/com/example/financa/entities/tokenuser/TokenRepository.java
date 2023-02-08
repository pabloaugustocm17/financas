package com.example.financa.entities.tokenuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenUser, Integer> {
}
