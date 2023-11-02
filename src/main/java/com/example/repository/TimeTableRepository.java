package com.example.repository;

import com.example.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

    Optional<TimeTable> findOneById(Long id);
//    @Query(value = "select t4.* from subjects t1\n" +
//            "inner join register_of_major_subject t2\n" +
//            "                     on t1.id = t2.subject_id\n" +
//            "inner join register_of_major t3\n" +
//            "                     on t3.id = t2.register_of_major,\n" +
//            "time_table t4\n" +
//            "where t4.subject_id = t1.id and t3.major_id = :majorId",
//    nativeQuery = true)
//    List<TimeTable> findAllBySubjectFromMajorId(@Param("majorId") Long majorId);
}

