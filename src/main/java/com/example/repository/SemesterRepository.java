package com.example.repository;

import com.example.entity.Semester;
import com.example.entity.SemesterEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
