package com.kevincode.helpers;

import org.springframework.stereotype.Component;

import com.kevincode.data.mysql.entitites.CourseMysqlEntity;
import com.kevincode.data.mysql.entitites.StudentMysqlEntity;
import com.kevincode.domain.models.CourseModel;
import com.kevincode.domain.models.StudentModel;

@Component
// @NoArgsConstructor
public class ConvertToMysql {
    public ConvertToMysql(){

    }
    
    public StudentMysqlEntity convertToMysql(StudentModel studentModel) {
        StudentMysqlEntity studentMysqlEntity = new StudentMysqlEntity(studentModel.getId(), studentModel.getName(),
                studentModel.getMaternalLastName(), studentModel.getPaternalLastName());
        return studentMysqlEntity;
    }
    
    public StudentModel convertToStudent(StudentMysqlEntity studentMysqlEntity) {
        StudentModel studentModel = new StudentModel(studentMysqlEntity.getId(), studentMysqlEntity.getName(),
         studentMysqlEntity.getPaternalLastName(), studentMysqlEntity.getMaternalLastName());
        return studentModel;
    }


    public CourseMysqlEntity convertToMysqlCourse(CourseModel courseModel) {
        CourseMysqlEntity courseMysqlEntity = new CourseMysqlEntity( courseModel.getId(), courseModel.getMateria()); 
        return courseMysqlEntity;
    }
    
    public CourseModel convertToStudentCourse(CourseMysqlEntity courseMysqlEntity) {
        CourseModel courseModel = new CourseModel(courseMysqlEntity.getId(), courseMysqlEntity.getMateria());
        return courseModel;
    }
    

}
