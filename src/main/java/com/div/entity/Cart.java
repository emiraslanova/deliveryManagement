package com.div.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(schema = "delivery",name = "cart")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name ="count")
    private byte count ;

    @Column(name = "total_amount")
    private  double totalAmount;

    @OneToMany
    private List<Food>foods;

    @OneToOne
    private User user;





}
