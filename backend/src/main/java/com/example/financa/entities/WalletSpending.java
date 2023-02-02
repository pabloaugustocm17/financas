package com.example.financa.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@NoArgsConstructor
@Table(name = "tb_spending")
public class WalletSpending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double spending;

    private LocalDate date;

    /* Relationship */

    @ManyToOne
    private Wallet wallet;


}
