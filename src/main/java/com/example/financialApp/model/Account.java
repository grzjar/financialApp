package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="accounts")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String accountName;
    @Column(scale = 2)
    private Double accountValue;
    @Column(name="created_on")
    private String createdOn;
    @Column(name="updated_on")
    private String updatedOn;

    @PrePersist
    private void prePersist(){
        createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"));
    }

    @PreUpdate
    private void preUpdate(){
        updatedOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"));
    }

    @ManyToOne
    private User user;

}
