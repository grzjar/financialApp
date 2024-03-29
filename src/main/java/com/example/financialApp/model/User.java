package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

}
