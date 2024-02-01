package com.kevincode.data.mysql.entitites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class StudentMysqlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String maternalLastName;
    @Column(nullable = false)
    private String paternalLastName;

    public StudentMysqlEntity(Long id, String name, String maternalLastName, String paternalLastName) {
        this.id = id;
        this.name = name;
        this.maternalLastName = maternalLastName;
        this.paternalLastName = paternalLastName;
    }
    
    // public StudentMysqlEntity() {
    // }

    //  @ManyToMany(mappedBy = "students")


    // private List<CourseMysqlEntity> Courses;
    

}
