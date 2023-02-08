package com.example.financa.entities.wallet;

import com.example.financa.entities.dtos.WalletDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.LinkedList;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query( "SELECT NEW com.example.financa.entities.dtos.WalletDTO( " +
            "wallet.id, wallet.name_wallet" +
            ")" +
            "FROM Wallet wallet " +
            "INNER JOIN wallet.user user " +
            "WHERE user.id = :id")
    LinkedList<WalletDTO> getAllWalletByUser(@Param("id") Long id);

    Wallet getWalletById(Long id);

}
