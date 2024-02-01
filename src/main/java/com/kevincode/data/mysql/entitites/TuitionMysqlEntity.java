package com.kevincode.data.mysql.entitites;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tuition")
public class TuitionMysqlEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(targetEntity = CourseMysqlEntity.class, fetch = FetchType.LAZY )
    //@JoinTable( joinColumns = @JoinColumn(name = "course") )
    private CourseMysqlEntity course;

     @ManyToOne(targetEntity = StudentMysqlEntity.class, fetch = FetchType.LAZY )
   // @JoinTable( joinColumns = @JoinColumn(name = "student") )
    private StudentMysqlEntity student;

    // @Column
    private LocalDate date;

    public TuitionMysqlEntity(Long id, CourseMysqlEntity course, StudentMysqlEntity student, LocalDate date,
        Double cost) {
      this.id = id;
      this.course = course;
      this.student = student;
      this.date = date;
      this.cost = cost;
    }

    @Column(nullable = false)
    private Double cost;
   

}
