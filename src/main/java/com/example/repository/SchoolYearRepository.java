package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SchoolYear;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
}
