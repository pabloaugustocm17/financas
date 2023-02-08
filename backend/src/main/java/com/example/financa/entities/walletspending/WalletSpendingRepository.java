package com.example.financa.entities.walletspending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletSpendingRepository extends JpaRepository<WalletSpending, Long> {

}
