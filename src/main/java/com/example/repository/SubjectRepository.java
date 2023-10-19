package com.example.repository;

import com.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = "SELECT * FROM subjects s " +
            "inner join subject_major sm " +
            "on s.id = sm.subject_id " +
            "inner join majors m " +
            "on sm.major_id = m.id " +
            "where m.id = :id",
            nativeQuery = true)
    List<Subject> findAllByMajorId(@Param("id") Long id);
    Optional<Subject> findOneById(Long id);


    @Procedure(name = "Subject.usp_CheckSubjectIdIsEmptyInRegister")
    Boolean checkSubjectIsEmptyBySubjectIdAndUsernameInRegisterRecord(
            @Param("subjectId") String subjectId,
            @Param("username") String username
    );
}
