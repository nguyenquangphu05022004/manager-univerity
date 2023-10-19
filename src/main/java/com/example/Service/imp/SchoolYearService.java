package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.SchoolYearConverter;
import com.example.dto.SchoolYearDTO;
import com.example.entity.Course;
import com.example.entity.SchoolYear;
import com.example.entity.Semester;
import com.example.entity.Student;
import com.example.repository.SchoolYearRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SchoolYearService implements GenericService<SchoolYearDTO> {

    @Autowired
    private SchoolYearRepository schoolYearRepository;
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private SchoolYearConverter schoolYearConverter;

    @Override
    public SchoolYearDTO save(SchoolYearDTO object) {
        List<Student> students = searchBy.findAllStudentByCourseId(object.getCourseId());
        List<Semester> semesters = searchBy.findAllSemester();
        Course course = searchBy.findCourseById(object.getCourseId());
        Set<Course> courses = new HashSet<>(); courses.add(course);
        SchoolYear schoolYear = SchoolYear.builder()
                .schoolYear(object.getSchoolYear())
                .semesters(semesters)
                .students(students)
                .courses(courses.stream().map((c) -> c).collect(Collectors.toList()))
                .build();
        return schoolYearConverter.toDto(schoolYearRepository.save(schoolYear));
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<SchoolYearDTO> list() {
        List<SchoolYear> list = schoolYearRepository.findAll();
        List<SchoolYearDTO> listDto = new ArrayList<>();
        return schoolYearConverter.dtoList(list);

    }

    @Override
    public SchoolYearDTO getById(Long id) {
        return null;
    }

    @Override
    public List<SchoolYearDTO> getByCode(String code) {
        return null;
    }
}
