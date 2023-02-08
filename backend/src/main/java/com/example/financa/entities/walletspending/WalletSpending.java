package com.example.financa.entities.walletspending;

import com.example.financa.actions.Utils;
import com.example.financa.entities.wallet.Wallet;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@NoArgsConstructor
@Data
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

    /* Init */

    public void init(double spending, LocalDate date){
        this.spending = spending;
        this.date = date;
    }

    /* Constructors */

    public WalletSpending(String spending, LocalDate date){
        init(Utils.stringToDouble(spending), date);
    }

    public WalletSpending(String spending, String date){
        init(Utils.stringToDouble(spending), Utils.stringToLocalDate(date));
    }

    public WalletSpending(double spending, String date){
        init(spending, Utils.stringToLocalDate(date));
    }

    public WalletSpending(double spending, LocalDate date){
        init(spending, date);
    }

}
