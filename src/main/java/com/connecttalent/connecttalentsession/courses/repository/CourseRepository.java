package com.connecttalent.connecttalentsession.courses.repository;

import com.connecttalent.connecttalentsession.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long > {

    Course findById(Integer id);


}
