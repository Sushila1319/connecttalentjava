package com.connecttalent.connecttalentsession.courses.dao;

import com.connecttalent.connecttalentsession.courses.model.Course;

import java.util.List;

public interface CourseDao {

    Course save(Course course);

    List<Course>getAll();

    Course findById(long id);

    Course update(Long id, Course updatedCourse);

    void deleteById(Long id);


}
