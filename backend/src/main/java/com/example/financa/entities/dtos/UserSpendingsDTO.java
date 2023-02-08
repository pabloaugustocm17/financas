package com.example.financa.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserSpendingsDTO {

    private String name_wallet;

    private double spending;

    private LocalDate date;

}
