package com.kevincode.data.mysql.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kevincode.data.mysql.entitites.StudentMysqlEntity;
import com.kevincode.data.mysql.repositories.StudentMysqlRepository;
import com.kevincode.domain.models.StudentModel;
import com.kevincode.domain.repositories.StudentDomainRepository;
import com.kevincode.helpers.ConvertToMysql;


@Service
//@AllArgsConstructor

public class StudentMReposImpl implements StudentDomainRepository {

    private StudentMysqlRepository studentMysqlRepository;
    private ConvertToMysql convertToMysql;
    

    public StudentMReposImpl(ConvertToMysql convertToMysql, StudentMysqlRepository studentMysqlRepository) {
        this.convertToMysql = convertToMysql;
        this.studentMysqlRepository = studentMysqlRepository;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentMysqlEntity> entities = studentMysqlRepository.findAll();
        List<StudentModel> models = new ArrayList<>();
        for (StudentMysqlEntity entity : entities) {
            models.add(convertToMysql.convertToStudent(entity));
        }
        return models;
    }

    @Override
    public StudentModel getById(Long id) {
        StudentMysqlEntity studentMysqlEntity = studentMysqlRepository.findById(id).get();
        // StudentsModel student = new StudentsModel(1L, "Alfredo", "Salinas", "Zeballos");
        return convertToMysql.convertToStudent(studentMysqlEntity);
    }

   

    @Override
    public StudentModel addStudent(StudentModel studentModel) {
        // System.out.println("==========================================================================");
        // System.out.println(studentModel.getName());
        System.out.println(convertToMysql.convertToMysql(studentModel).getPaternalLastName());
        studentMysqlRepository.save(convertToMysql.convertToMysql(studentModel));
        return studentModel;
    }



    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    

}
