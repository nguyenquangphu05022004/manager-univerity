package com.example.repository;

import com.example.entity.StudentExchangeRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentExchangeRegisterRepository
        extends JpaRepository<StudentExchangeRegister, Long> {
    Optional<StudentExchangeRegister> findOneById(Long id);

    @Query(value = "select\n" +
            "  s3.*\n" +
            "from register s1 inner join register_exchange_student s2 on s1.id = s2.register_id\n" +
            "inner join student_exchange_register s3 on s2.student_exchange_subject_id = s3.id\n" +
            "where s1.register_of_major_id = :registerOfMajorId",
        nativeQuery = true)
    List<StudentExchangeRegister> findAllByRegisterOfMajorIdCustom(@Param("registerOfMajorId") Long registerOfMajorId);
}
