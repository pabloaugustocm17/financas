package com.example.financa.entities.walletspending;

import com.example.financa.entities.dtos.UserSpendingsDTO;
import com.example.financa.entities.dtos.WalletSpendingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface WalletSpendingRepository extends JpaRepository<WalletSpending, Long> {

    @Query( "SELECT NEW com.example.financa.entities.dtos.WalletSpendingDTO ( " +
            "ws.spending, ws.date " +
            ")" +
            "FROM WalletSpending ws " +
            "INNER JOIN ws.wallet wallet " +
            "WHERE wallet.id = :id ")
    LinkedList<WalletSpendingDTO> getWalletSpendingByWallet(@Param("id") Long id);

    @Query( "SELECT NEW com.example.financa.entities.dtos.UserSpendingsDTO (" +
            "wallet.name_wallet, " +
            "ws.spending, ws.date " +
            ")" +
            "FROM WalletSpending ws " +
            "INNER JOIN ws.wallet wallet " +
            "INNER JOIN wallet.user user " +
            "WHERE user.id = :id ")
    LinkedList<UserSpendingsDTO> getWalletsSpendingByUser(@Param("id") Long id);

}
