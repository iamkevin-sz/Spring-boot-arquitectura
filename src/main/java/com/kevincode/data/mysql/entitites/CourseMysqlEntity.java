package com.kevincode.data.mysql.entitites;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@Table(name = "Course")
public class CourseMysqlEntity {
    public CourseMysqlEntity(Long id, String materia) {
        this.id = id;
        this.materia = materia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String materia;

    // @JoinTable(name = "tuition", joinColumns = @JoinColumn(name = "id_course", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false))
    // @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    // private List<StudentMysqlEntity> students;

   

}
