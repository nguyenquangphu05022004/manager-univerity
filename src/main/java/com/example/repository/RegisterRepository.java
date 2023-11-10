package com.example.repository;

import com.example.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    Optional<Register> findOneById(Long id);
    List<Register> findAllByStudentId(Long id);
    @Transactional
    @Modifying
    @Query(value = "delete from Register r where r.id = :id")
    void deleteRegisterById(@Param("id") Long id);

}
