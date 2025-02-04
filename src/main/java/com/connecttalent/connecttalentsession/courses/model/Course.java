package com.connecttalent.connecttalentsession.courses.model;

import com.connecttalent.connecttalentsession.usersaddress.model.TemporaryAddress;
import com.connecttalent.connecttalentsession.usersaddress.model.UsersAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String courseName;

    private String level;

    private String syllabus;

    private String instructor;

    private String modeOfDelivery;

    private String duration;

    private Integer cost;




}

