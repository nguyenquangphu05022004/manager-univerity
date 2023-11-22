package com.example.repository;

import com.example.entity.Major;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, Long> {
    Optional<Major> findOneByMajorCode(String code);
    Optional<Major> findOneById(Long id);
}
