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
    @Column(scale = 2, name = "account_value")
    private Double accountValue;
    private String currency = "PLN";
    @Column(name="created_on")
    private String createdOn;
    @Column(name="updated_on")
    private String updatedOn;
  //  @Column
    @Formula("(select sum(i.value) from incomes i where i.account_id = id)")
    private Double sumIncome;
 //   @Column
    @Formula("(select sum(o.value) from outcomes o where o.account_id = id)")
    private Double sumOutcome;

    @Formula("account_value + sumIncome - sumOutcome")
    private Double sum;



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
