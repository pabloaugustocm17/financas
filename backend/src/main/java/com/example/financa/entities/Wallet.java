package com.example.financa.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tb_wallet")
public class Wallet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Relationship */

    @ManyToOne
    private User user;

}
