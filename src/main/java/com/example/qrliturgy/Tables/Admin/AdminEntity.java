package com.example.qrliturgy.Tables.Admin;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Entity
@Data
@Table(name = "Admin")
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

}
