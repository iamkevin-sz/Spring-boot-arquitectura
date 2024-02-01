package com.kevincode.data.mysql.implement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kevincode.data.mysql.entitites.TuitionMysqlEntity;
import com.kevincode.data.mysql.repositories.TuitionMysqlRepository;
import com.kevincode.domain.models.TuitionModel;
import com.kevincode.domain.repositories.TuitionDomainRepository;
import com.kevincode.helpers.ConvertToMysql;

@Repository
// @AllArgsConstructor
public class TuitionMReposImpl implements TuitionDomainRepository {

    // private final Logger log = LoggerFactory.getLogger(TuitionMReposImpl.class);
    private final TuitionMysqlRepository tuitionMysqlRepository;
    private ConvertToMysql convertToMysql;

    public TuitionMReposImpl(TuitionMysqlRepository tuitionMysqlRepository, ConvertToMysql convertToMysql) {
        this.tuitionMysqlRepository = tuitionMysqlRepository;
        this.convertToMysql = convertToMysql;
    }

    @Override
    public TuitionModel addMatricula(TuitionModel tuitionModel) {
        
        try {
            TuitionMysqlEntity tuitionMysqlEntity = new TuitionMysqlEntity();
            tuitionMysqlEntity.setId(tuitionModel.getIdTuition());
            tuitionMysqlEntity.setStudent(convertToMysql.convertToMysql(tuitionModel.getIdStudent()));
            tuitionMysqlEntity.setCourse(convertToMysql.convertToMysqlCourse(tuitionModel.getIdCourse()));
            tuitionMysqlEntity.setDate(tuitionModel.getDateRegistration());
            tuitionMysqlEntity.setCost(tuitionModel.getCost());
            System.out.println(tuitionMysqlEntity.getStudent());
            tuitionMysqlRepository.save(tuitionMysqlEntity);
            return tuitionModel;
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar la matrícula", e);
        }    

        

    }

    // @Override
    // public TuitionModel addMatricula(TuitionModel tuitionModel) {
    // System.out.println(tuitionModel.getCost());
    // // TuitionMysqlEntity prueba = new
    // TuitionMysqlEntity(tuitionModel.getIdTuition(), tuitionModel.getIdCourse(),
    // tuitionModel.getIdStudent(), tuitionModel.getCost());
    // // System.out.println(prueba.getId()+ " " + prueba.getId_course()+ " " +
    // prueba.getId_student()+ " " + prueba.getCost());
    // tuitionMysqlRepository.save(new
    // TuitionMysqlEntity(tuitionModel.getIdTuition(), tuitionModel.getIdCourse(),
    // tuitionModel.getIdStudent(), tuitionModel.getCost()));
    // return tuitionModel;
    // }

    @Override
    public LocalDate getTuitionDate(Long studentId, LocalDate startDate, LocalDate endDate) {

        // try {

        // List<LocalDate> dates = tuitionMysqlRepository.findByQuery(
        // studentId,
        // startDate,
        // endDate);

        // if (!dates.isEmpty()) {
        // return dates.get(0);
        // } else {
        // return null;
        // }

        // } catch (Exception e) {

        // log.error("Error retrieving tuition date", e);
        // throw new RuntimeException("Error retrieving date", e);

        // }
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    @Override
    public List<TuitionModel> getAllItems() {

        // List<TuitionMysqlEntity> tuitionMysqlEntities = tuitionMysqlRepository.findAll();
        // List<TuitionModel> tuitioModels = new ArrayList<>();
        // for (TuitionMysqlEntity tuitionsE : tuitionMysqlEntities) {
        //     tuitioModels.add(new TuitionModel(tuitionsE.getId(), tuitionsE.getId_student(), tuitionsE.getId_course(),
        //             tuitionsE.getDate(), tuitionsE.getCost()));
        // }
        // return tuitioModels;

        throw new UnsupportedOperationException("Unimplemented method 'getById'");

    }

    @Override
    public TuitionModel getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public TuitionModel addItems(TuitionModel t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStudent'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
