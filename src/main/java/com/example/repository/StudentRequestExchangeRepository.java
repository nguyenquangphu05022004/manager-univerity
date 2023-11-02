package com.example.repository;

import com.example.entity.StudentRequestExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRequestExchangeRepository
        extends JpaRepository<StudentRequestExchange, Long> {

    Optional<StudentRequestExchange> findOneById(Long id);
    List<StudentRequestExchange> findAllByCreateBy(String username);

    @Procedure(name = "confirmResponse")
    Boolean confirmResponse(@Param("studentRequestId") Long studentRequest, @Param("studentResponseId") Long studentResponse);
}
