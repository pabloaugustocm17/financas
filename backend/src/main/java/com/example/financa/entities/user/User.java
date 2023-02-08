package com.example.financa.entities.user;

import com.example.financa.actions.Utils;
import com.example.financa.entities.tokenuser.TokenUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "tb_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private LocalDate birth_date;

    /* Relationship */
    @OneToOne(optional = false)
    private TokenUser tokne_user;


    /* Init */

    public void init(String email, String password, String name ,LocalDate birth_date){
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth_date = birth_date;
        createToken();
    }

    /* Constructors */

    public User(String email, String password, String name, String birth_date){
        init(email, password, name, Utils.stringToLocalDate(birth_date));
    }

    public User(String email, String password, String name, LocalDate birth_date){
        init(email, password, name, birth_date);
    }

    /* Validates */

    public void createToken(){
        this.tokne_user = new TokenUser(this.birth_date);
    }

}
