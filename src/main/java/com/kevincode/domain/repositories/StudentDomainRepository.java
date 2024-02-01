package com.kevincode.domain.repositories;

import java.util.List;

import com.kevincode.domain.models.StudentModel;

public interface StudentDomainRepository {
    
    public List<StudentModel> getAllStudents();
    public StudentModel getById(Long id);  
    public StudentModel addStudent(StudentModel studentModel);
    void delete(Long id);
}
