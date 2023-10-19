package com.example.repository;

import com.example.entity.Student;
import com.example.entity.StudentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import java.util.List;
import java.util.Optional;

public interface StudentRequestRepository extends JpaRepository<StudentRequest, Long> {


    Optional<StudentRequest> findOneById(Long id);
    Optional<StudentRequest> findOneByStudentRequestUsernameAndSubjectRequestIdAndStatus(String username, Long subjectId, Boolean status);
    List<StudentRequest> findAllByStudentRequestUsernameAndStatus(String username, Boolean status);
    List<StudentRequest> findAllByStatus(Boolean status);

    @Procedure(name = "confirmResponse")
    Boolean confirmResponse(@Param("studentRequestId") Long studentRequest, @Param("studentResponseId") Long studentResponse);
}
