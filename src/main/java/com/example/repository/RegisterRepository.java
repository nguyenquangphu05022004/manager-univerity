package com.example.repository;

import com.example.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    Optional<Register> findOneById(Long id);
    Optional<Register> findOneByStudentIdAndSubjectId(Long studentId, Long subjectId);
    List<Register> findAllByStudentId(Long studentId);

    @Transactional
    @Modifying
    @Query(value = "delete from Register r where r.id = ?1")
    void deleteRegisterById(Long id);

}
