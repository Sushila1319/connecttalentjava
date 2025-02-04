package com.connecttalent.connecttalentsession.courses.controller;

import com.connecttalent.connecttalentsession.courses.model.Course;
import com.connecttalent.connecttalentsession.courses.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor
@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    
    @PostMapping("save")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        course = this.courseService.save(course);
        return ResponseEntity.ok(course);
    }

    @GetMapping("list")
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(this.courseService.getAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.courseService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Course not found with the Id number " + id));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course updatedCourse) {
        try {
            return ResponseEntity.ok(this.courseService.update(id, updatedCourse));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Unable to update course with the Id number " + id));
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id) {
        try {
            this.courseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Unable to delete course with the Id number " + id));
        }
    }

}