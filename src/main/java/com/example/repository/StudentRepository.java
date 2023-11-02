package com.example.repository;

import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findOneById(Long id);
    Optional<Student> findOneByPerson(Long id);
    List<Student> findAllByCourseId(Long courseId);

}
