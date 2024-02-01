package com.kevincode.domain.repositories;

import com.kevincode.domain.models.CourseModel;

public interface CourseDomainRepository extends CrudRepository<CourseModel>{

    public void addCourses(CourseModel courseModel);
    
}
