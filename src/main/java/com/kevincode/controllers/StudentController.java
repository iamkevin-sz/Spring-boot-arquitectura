package com.kevincode.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevincode.domain.models.StudentModel;
import com.kevincode.domain.repositories.StudentDomainRepository;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentDomainRepository studentDomainRepository;

    public StudentController(StudentDomainRepository studentDomainRepository) {
        this.studentDomainRepository = studentDomainRepository;
    }

    @RequestMapping("/students")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(studentDomainRepository.getAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener los estudiantes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/student")
    public ResponseEntity<?> addItem(@Validated @RequestBody StudentModel studentModel) {
        try {
            System.out.println("Apellido" + studentModel.getPaternalLastName());
            return new ResponseEntity<>(studentDomainRepository.addStudent(studentModel), HttpStatus.CREATED);
        } catch (NullPointerException e) {
            return new ResponseEntity<>("El nombre es obligatorio", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar el estudiante", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getById(@Validated @PathVariable Long id) {
        // return new ResponseEntity<>(repository.getById(id), HttpStatus.CREATED);
        return new ResponseEntity<>(studentDomainRepository.getById(id), HttpStatus.OK);
    }

}
