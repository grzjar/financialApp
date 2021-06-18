package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
}
