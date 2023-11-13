package com.div.entity;

import com.div.entity.Cart;
import com.div.entity.Category;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(schema = "delivery",name = "food")
@Entity

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "name",length = 30,nullable = false)
    private String name;

    @Column(name = "description")
    private  String desc;

    @Column(name = "amount")
    private double amount;

    @Column(name = "food_details")
    private String foodDetails;

    @Column(name = "image")
    private String image;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Cart cart;









}
