package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findOneById(Long id);
    Optional<Student> findOneByPerson(Long id);
    List<Student> findAllByCourseId(Long courseId);

}
