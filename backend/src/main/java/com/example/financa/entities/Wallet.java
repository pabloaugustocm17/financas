package com.example.financa.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Entity
@NoArgsConstructor
@Table(name = "tb_wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name_wallet;

    /* Relationship */

    @ManyToOne
    private User user;

    /* Constructor */

    public Wallet(User user) {
        this.user = user;
        this.name_wallet = "Wallet Default";
    }

    public Wallet(String name_wallet, User user){
        this.name_wallet = name_wallet;
        this.user = user;
    }
}
