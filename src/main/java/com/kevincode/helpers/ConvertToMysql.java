package com.kevincode.helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.kevincode.data.mysql.entitites.CourseMysqlEntity;
import com.kevincode.data.mysql.entitites.StudentMysqlEntity;
import com.kevincode.domain.models.CourseModel;
import com.kevincode.domain.models.StudentModel;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Component
// @NoArgsConstructor
public class ConvertToMysql {
    public ConvertToMysql() {

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
        CourseMysqlEntity courseMysqlEntity = new CourseMysqlEntity(courseModel.getId(), courseModel.getMateria());
        return courseMysqlEntity;
    }

    public CourseModel convertToStudentCourse(CourseMysqlEntity courseMysqlEntity) {
        CourseModel courseModel = new CourseModel(courseMysqlEntity.getId(), courseMysqlEntity.getMateria());
        return courseModel;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("====== Proyecto Arquitectura en capas ======")
                        .version("0.1")
                        .description(
                                "Es una app por capas que tiene students, tuitions y courses.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
