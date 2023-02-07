package com.example.financa.repository;

import com.example.financa.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WalletRepository extends JpaRepository<Wallet, Long> {


}
