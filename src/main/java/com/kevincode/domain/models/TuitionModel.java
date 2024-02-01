package com.kevincode.domain.models;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TuitionModel {
    
   private Long idTuition;

   private StudentModel idStudent;
   private CourseModel idCourse;

   private LocalDate dateRegistration;
   // private String academicPeriod;
   // private String state;
   private Double cost;
   
//    private StudentModel studentModel;

   public TuitionModel() {
    
   }

}
