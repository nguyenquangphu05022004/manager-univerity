package com.example.repository;

import com.example.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findOneById(Long id);
    List<Grade> findAllByRegisterRegisterOfMajorId(Long registerOfMajorId);
}
