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

    @Query(value = "select s1.*\n" +
            "from student_exchange_register s1\n" +
            "       inner join register s2 on s1.register_id = s2.id\n" +
            "where s1.student_id != :studentId\n" +
            "  and s2.time_table_id not in (select r1.time_table_id\n" +
            "                               from register r1\n" +
            "                               where r1.student_id = :studentId)\n",
    nativeQuery = true)
    List<StudentExchangeRegister> findAllByStudentIdDifferent(@Param("studentId") Long studentId);
}
