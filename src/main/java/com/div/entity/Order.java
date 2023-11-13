package com.div.entity;

import com.div.entity.Cart;
import com.div.entity.Driver;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(schema = "delivery",name = "order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "place", length = 34,nullable = false)
    private String place;


    @Column(name = "status")
    private boolean status;


    @OneToOne
    private Cart cart;

    @OneToOne
    private Driver driver;








}
