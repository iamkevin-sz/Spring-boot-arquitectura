package com.kevincode.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevincode.domain.models.CourseModel;
import com.kevincode.domain.repositories.CourseDomainRepository;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseDomainRepository courseDomainRepository;

    public CourseController(CourseDomainRepository courseDomainRepository) {
        this.courseDomainRepository = courseDomainRepository;
    }

    @PostMapping("/course")
    public ResponseEntity<?> addItem(@Validated @RequestBody CourseModel CourseModel) {
        // System.out.println("==========================================================");
        // System.out.println("Materia" + CourseModel.getMateria());
        return new ResponseEntity<>(courseDomainRepository.addItems(CourseModel), HttpStatus.CREATED);
    }

    @PostMapping("/addCourses")
    public void addCourses(@Validated @RequestBody CourseModel CourseModel) {
        // System.out.println("==========================================================");
        // System.out.println("Materia" + CourseModel.getMateria());
        courseDomainRepository.addCourses(CourseModel);
    }


     @GetMapping("/course/{id}")
    public ResponseEntity<?> getById(@Validated @PathVariable Long id){
        System.out.println("==========================================================");
        return new ResponseEntity<>(courseDomainRepository.getById(id), HttpStatus.OK);
    }

    @RequestMapping("/courses")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(courseDomainRepository.getAllItems(), HttpStatus.OK);
    }


}
