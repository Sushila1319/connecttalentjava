package com.connecttalent.connecttalentsession.courses.service;

import com.connecttalent.connecttalentsession.courses.model.Course;

import java.util.List;

public interface CourseService {

    Course save(Course course);

    List<Course> getAll();

    Course findById(Long id);

    Course update(Long id, Course updatedCourse);

    void deleteById(Long id);

}
