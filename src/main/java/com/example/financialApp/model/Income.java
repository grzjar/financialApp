package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="incomes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String category;
    @Column(scale = 2)
    private Double value;
    private String currency = "PLN";
    //TODO LocalDateTime zamiast String + @DateTimeFormat("yyyy-MM-dd HH:mm:ss)
    @Column(name="created_on")
    private String createdOn;

    @PrePersist
    private void prePersist(){
        createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"));
    }

    @ManyToOne
    public Account account;
}
