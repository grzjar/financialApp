package com.example.financialApp.model;

import lombok.*;
import org.hibernate.annotations.Formula;

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
    @Column(name = "account_name")
    private String accountName;
    private String currency = "PLN";
    @Column(name="created_on")
    private String createdOn;


    @Formula("(select sum(i.value) from incomes i where i.account_id = id)")
    private Double sumIncome;
    @Formula("(select sum(o.value) from outcomes o where o.account_id = id)")
    private Double sumOutcome;
    //TODO Akurat to pole mogłoby być już wyliczone w metodzie z adnotacją @PostLoad
    //     alternatywnie mogłoby nie być tego pola a jedynie getter zwracający wynik obliczenia
    @Formula("((select sum(i.value) from incomes i where i.account_id = id) - (select sum(o.value) from outcomes o where o.account_id = id))")
    @Transient //TODO Aby tego pola nie zapisywać do bazy, jeżeli nie używamy @Formula
    private Double sum;

    @PostLoad
    private void postLoad() {
        this.sum = (sumOutcome != null ? sumOutcome : 0) - (sumIncome != null ? sumIncome : 0);
    }

    @PrePersist
    private void prePersist(){
        createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"));
    }


    //TODO Pola grupujemy razem, metody razem
    @ManyToOne
    private User user;

}
