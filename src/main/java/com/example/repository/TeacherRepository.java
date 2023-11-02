package com.example.repository;

import com.example.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  TeacherRepository extends JpaRepository<Teacher, Long> {
        Optional<Teacher> findOneById(Long id);
}
