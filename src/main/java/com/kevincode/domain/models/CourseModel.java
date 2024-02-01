package com.kevincode.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructors
@NoArgsConstructor
public class CourseModel {    
    private Long id;
    private String materia;
    public CourseModel(Long id, String materia) {
        this.id = id;
        this.materia = materia;
    }

    
}
