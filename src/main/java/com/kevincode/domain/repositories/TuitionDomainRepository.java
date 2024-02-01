package com.kevincode.domain.repositories;

import java.time.LocalDate;

import com.kevincode.domain.models.TuitionModel;

public interface TuitionDomainRepository extends CrudRepository<TuitionModel>{
    public LocalDate getTuitionDate(Long studentId, LocalDate startDate, LocalDate endDate);

    public TuitionModel addMatricula(TuitionModel tuitionModel);

}
