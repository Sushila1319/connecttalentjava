package com.connecttalent.connecttalentsession.usersaddress.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_address")
public class UsersAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_address")
    private String street1;

    private String street2;

    private String city;

    private String country;

    private Integer postalCode;


}

