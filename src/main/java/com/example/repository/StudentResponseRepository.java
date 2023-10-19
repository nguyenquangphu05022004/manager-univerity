package com.example.repository;

import com.example.entity.Student;
import com.example.entity.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentResponseRepository extends JpaRepository<StudentResponse, Long> {
    Optional<StudentResponse> findOneById(Long id);
}
