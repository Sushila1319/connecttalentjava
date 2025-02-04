package com.connecttalent.connecttalentsession.courses.service.impl;

import com.connecttalent.connecttalentsession.courses.dao.CourseDao;
import com.connecttalent.connecttalentsession.courses.model.Course;
import com.connecttalent.connecttalentsession.courses.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao){
        this.courseDao = courseDao;
    }

    @Override
    public Course save(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public List<Course> getAll() {
        return this.courseDao.getAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseDao.findById(id);
    }


    @Override
    public Course update(Long id, Course updatedCourse){
        return this.courseDao.update(id, updatedCourse);
    }

    @Override
    public void deleteById(Long id) {
        this.courseDao.deleteById(id);
    }


}

