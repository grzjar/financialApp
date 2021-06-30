package com.example.financialApp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="categories")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="category_name")
    private String categoryName;

    @ManyToOne
    private Account account;
}
