package com.kevincode.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {
    
    private Long id;
    private String name;
    private String maternalLastName;
    private String paternalLastName;

    

}
