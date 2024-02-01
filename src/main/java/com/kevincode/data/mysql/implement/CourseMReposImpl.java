package com.kevincode.data.mysql.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kevincode.data.mysql.entitites.CourseMysqlEntity;
import com.kevincode.data.mysql.repositories.CourseMysqlRepository;
import com.kevincode.domain.models.CourseModel;
import com.kevincode.domain.repositories.CourseDomainRepository;
import com.kevincode.helpers.ConvertToMysql;

// @AllArgsConstructor
@Service
public class CourseMReposImpl implements CourseDomainRepository {

    private CourseMysqlRepository courseMysqlRepository;
    private ConvertToMysql convertToMysql;

    public CourseMReposImpl(ConvertToMysql convertToMysql, CourseMysqlRepository courseMysqlRepository) {
        this.convertToMysql = convertToMysql;
        this.courseMysqlRepository = courseMysqlRepository;
    }

    @Override
    public List<CourseModel> getAllItems() {
        List<CourseMysqlEntity> courseMysqlEntityIterable = courseMysqlRepository.findAll();
        List<CourseModel> courseModelList = new ArrayList<>();
        for (CourseMysqlEntity courseMysqlEntity : courseMysqlEntityIterable) {
            courseModelList.add(convertToMysql.convertToStudentCourse(courseMysqlEntity));
            // System.out.println("creado " + courseModelList.size());
        }
        return courseModelList;
    }

    @Override
    public CourseModel getById(Long id) {
        CourseMysqlEntity courseMysqlEntity = courseMysqlRepository.findById(id).get();
        return convertToMysql.convertToStudentCourse(courseMysqlEntity);

    }

    @Override
    public CourseModel addItems(CourseModel courseModel) {
        courseMysqlRepository.save(convertToMysql.convertToMysqlCourse(courseModel));
    // CourseMysqlEntity prueba = new CourseMysqlEntity(courseModel.getId(), courseModel.getMateria());
    // System.out.println(prueba.getId()+ " " + prueba.getMateria());
        return courseModel;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void addCourses(CourseModel courseModel) {
        courseMysqlRepository.save(convertToMysql.convertToMysqlCourse(courseModel));
    }

}
