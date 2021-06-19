package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "accountName")
    private List<Account> accounts = new ArrayList<>();

}