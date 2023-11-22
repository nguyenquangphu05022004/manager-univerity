package com.example.repository;

import com.example.entity.RegisterOfMajor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterOfMajorRepository extends JpaRepository<RegisterOfMajor, Long> {

    Optional<RegisterOfMajor> findOneByMajorId(Long majorId);
    List<RegisterOfMajor> findAllByMajorId(Long majorId);
    Optional<RegisterOfMajor> findOneById(Long id);
}
