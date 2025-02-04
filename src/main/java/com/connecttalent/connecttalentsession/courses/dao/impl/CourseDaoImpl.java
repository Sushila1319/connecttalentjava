package com.connecttalent.connecttalentsession.courses.dao.impl;

import com.connecttalent.connecttalentsession.courses.dao.CourseDao;
import com.connecttalent.connecttalentsession.courses.model.Course;
import com.connecttalent.connecttalentsession.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao {
    private final CourseRepository courseRepository;

    public CourseDaoImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);

    }

    @Override
    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Not Found"));
    }



    @Override
    public Course update(Long id, Course updatedCourse) {
        Course existingCourse = findById(id);
        existingCourse.setCourseName(updatedCourse.getCourseName());
        return this.courseRepository.save(existingCourse);
    }

    @Override
    public void deleteById(Long id) {
        Course existingCourse = findById(id);
        this.courseRepository.delete(existingCourse);
    }
}