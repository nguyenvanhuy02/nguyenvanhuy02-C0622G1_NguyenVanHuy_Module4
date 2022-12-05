package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select student.* from `student` join `class_student` on student.class_id = class_student.id\n" +
            "where student.name like %:name% and class_student.name_class like %:nameClass% and status = 1" ,nativeQuery = true)
    Page<Student> findAllStudent(@Param("name") String name ,
                                 @Param("nameClass") String nameClass,
                                 Pageable pageable);
}
