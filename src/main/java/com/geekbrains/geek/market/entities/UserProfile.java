package com.geekbrains.geek.market.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "gender")
    private char gender;

    @Column(name = "birth_year")
    private int birthyear;

    @Column(name = "hometown")
    private String hometown;
}
