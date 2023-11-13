package com.div.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(schema = "delivery",name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "name ",length = 30)
    private  String name ;

    @Column(name = "surname",length = 50)
    private  String surname;

    @Column(name = "birth-date")
    private LocalDate birthdate;

    @Column(unique = true)
    @Pattern(regexp = "[\\w.-]+@[\\w.-]+.\\w+$")
    private  String email;

    @Column(name = "password",length = 30)
    private String password;

    @Pattern(regexp = "[0-9]{3}+[0-9]{3}+[0-9]{2}+[0-9]{2}")
    private String phoneNumber;
    @Column(name = "active")
    private  boolean active;

    @ManyToMany
    @JoinTable(schema = "delivery",
    name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;











}
