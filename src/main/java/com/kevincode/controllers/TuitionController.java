package com.kevincode.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevincode.domain.models.CourseModel;
import com.kevincode.domain.models.StudentModel;
import com.kevincode.domain.models.TuitionModel;
import com.kevincode.domain.repositories.CourseDomainRepository;
import com.kevincode.domain.repositories.StudentDomainRepository;
import com.kevincode.domain.repositories.TuitionDomainRepository;

@RestController
@RequestMapping("/api")
public class TuitionController {

    private TuitionDomainRepository tuitionDomainRepository;
    private StudentDomainRepository studentDomainRepository;
    private CourseDomainRepository courseDomainRepository;

    public TuitionController(TuitionDomainRepository tuitionDomainRepository,
            StudentDomainRepository studentDomainRepository, CourseDomainRepository courseDomainRepository) {
        this.tuitionDomainRepository = tuitionDomainRepository;
        this.studentDomainRepository = studentDomainRepository;
        this.courseDomainRepository = courseDomainRepository;
    }

    @GetMapping("/tuitions")    
    public ResponseEntity<?> getAllTuition() {
        try {
        return new ResponseEntity<>(tuitionDomainRepository.getAllItems(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al obtener las matrículas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tuition/{idStudent}/{idCourse}")
    public ResponseEntity<?> addMatricula(@PathVariable("idStudent") Long idStudent,
            @PathVariable("idCourse") Long idCourse) {
        try {

            StudentModel studentModel = studentDomainRepository.getById(idStudent);
            CourseModel courseModel = courseDomainRepository.getById(idCourse);

            TuitionModel tuitionModel = new TuitionModel();
            tuitionModel.setIdStudent(studentModel);
            tuitionModel.setIdCourse(courseModel);
            tuitionModel.setDateRegistration(null);
            tuitionModel.setCost(50.0);

            // Asigna el ID automáticamente (si la lógica lo permite)
            tuitionModel.setIdTuition(null); // Elimina la asignación manual

            TuitionModel savedTuition = tuitionDomainRepository.addMatricula(tuitionModel);
            return new ResponseEntity<>(savedTuition, HttpStatus.CREATED);

            
            

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Estudiante o curso no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la matrícula", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/tuition")
    // public ResponseEntity<?> addMatricula(@RequestBody TuitionModel tuitionModel)
    // {
    // return new
    // ResponseEntity<>(tuitionDomainRepository.addMatricula(tuitionModel),
    // HttpStatus.CREATED );
    // // return "soy yo";

    // }

    // @PostMapping("/tuition/{idStudent}/{idCourse}")
    // public ResponseEntity<?> addMatricula(@PathVariable("idStudent") Long
    // idStudent, @PathVariable("idCourse") Long idCourse) {
    // StudentModel studentModel = studentDomainRepository.getById(idStudent);
    // CourseModel courseModel = courseDomainRepository.getById(idCourse);
    // TuitionModel tuitionModel = new TuitionModel();
    // tuitionModel.setIdTuition(4L);
    // tuitionModel.setIdStudent(studentModel);
    // tuitionModel.setIdCourse(courseModel);
    // tuitionModel.setDateRegistration(null);
    // tuitionModel.setCost(50.0);
    // return new
    // ResponseEntity<>(tuitionDomainRepository.addMatricula(tuitionModel),
    // HttpStatus.CREATED );
    // // return "soy yo";

    // }
}

// @GetMapping("/Tuition/{id}/tuitionDate")
// public ResponseEntity getTuitionDate(@PathVariable Long id,
// @RequestParam("startDate") String startDateString,
// @RequestParam("endDate") String endDateString) {

// try {
// LocalDate startDate = LocalDate.parse(startDateString);
// LocalDate endDate = LocalDate.parse(endDateString);

// LocalDate tuitionDate = tuitionDomainRepository.getTuitionDate(id, startDate,
// endDate);
// return new ResponseEntity<>(tuitionDate, HttpStatus.OK);

// } catch (Exception e) {
// // Maneja los errores de forma apropiada, por ejemplo:
// return new ResponseEntity<>("Error retrieving tuition date",
// HttpStatus.BAD_REQUEST);
// }
// }
