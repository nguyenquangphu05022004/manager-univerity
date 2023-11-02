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

    @Query(value = "select\n" +
            "  sj.*\n" +
            "from subjects sj\n" +
            "      inner join register_of_major_subject rms\n" +
            "      on sj.id = rms.subject_id\n" +
            "      inner join register_of_major m2\n" +
            "      on rms.register_of_major = m2.id\n" +
            "      inner join subject_major_schoolyear s2\n" +
            "      on m2.id = s2.register_major_id\n" +
            "      inner join schoolyear s3\n" +
            "      on s2.schoolyear_id = s3.id\n" +
            "      inner join schoolyear_course s4\n" +
            "      on s3.id = s4.schoolyear_id\n" +
            "      inner join courses c on s4.course_id = c.id\n" +
            "where m2.major_id = :majorId and s3.id = :schoolYearId and c.id = :courseId and m2.semester_id = :semesterId\n",
            nativeQuery = true
    )
    List<Subject> findAllByMajorIdAndSchoolYearIdAndCourseIdAndSemesterId
            (@Param("majorId") Long majorId, @Param("schoolYearId") Long schoolYearId,
             @Param("courseId") Long courseId, @Param("semesterId") Long semesterId);


//    @Procedure(name = "Subject.usp_CheckSubjectIdIsEmptyInRegister")
//    Boolean checkSubjectIsEmptyBySubjectIdAndUsernameInRegisterRecord(
//            @Param("subjectId") String subjectId,
//            @Param("username") String username
//    );



}
