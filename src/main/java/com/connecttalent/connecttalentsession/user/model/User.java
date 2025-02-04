package com.connecttalent.connecttalentsession.user.model;

import com.connecttalent.connecttalentsession.usersaddress.model.TemporaryAddress;
import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_names")
    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private Integer age;

    private String gender;

    @Column(length = 5000)
    private String refreshToken;

    @OneToOne(cascade = CascadeType.ALL )
    private UsersAddress address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    private List<TemporaryAddress> temporaryAddresses;

}

