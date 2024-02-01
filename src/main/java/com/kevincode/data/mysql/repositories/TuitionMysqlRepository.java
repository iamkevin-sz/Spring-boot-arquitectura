package com.kevincode.data.mysql.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kevincode.data.mysql.entitites.TuitionMysqlEntity;

public interface TuitionMysqlRepository extends JpaRepository<TuitionMysqlEntity, Long> {

  // @Query("select t.date from TuitionMysqlEntity t where t.student.id  = :studentId and t.date between :startDate and :endDate")
  // List<LocalDate> findByQuery(
  //     @Param("studentId") Long studentId,
  //     @Param("startDate") LocalDate startDate,
  //     @Param("endDate") LocalDate endDate);
}
