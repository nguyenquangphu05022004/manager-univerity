package com.example.repository;

import com.example.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByMajorId(Long id);
}
