package com.connecttalent.connecttalentsession.usersaddress.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class TemporaryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street1;

    @Column(nullable = false)
    private String street2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;


}
