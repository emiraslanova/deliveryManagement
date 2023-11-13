package com.div.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(schema = "delivery",name = "company")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "name",length = 30,nullable = false)
    private String name;

    @Column(name = "description",length = 30,nullable = false)
    private  String desc;

    @Column(name = "total_budget",nullable = false)
    private double totalBudget;
}















