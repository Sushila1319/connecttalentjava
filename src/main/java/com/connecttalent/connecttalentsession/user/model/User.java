package com.connecttalent.connecttalentsession.user.model;

import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    @OneToOne(cascade = CascadeType.ALL )
    private UsersAddress address;


}

