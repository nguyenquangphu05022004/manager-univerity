package com.example.Service.imp;


import com.example.entity.*;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericSearchBy {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private StudentRequestRepository studentRequestRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentResponseRepository studentResponseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SchoolYearRepository schoolYearRepository;
    @Autowired
    private RegisterOfMajorRepository registerOfMajorRepository;
    public Group findByIdGroup(Long id) {
        return (groupRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Group không tồn tại mã: " + id);
                }));
    }
    public Major findByCodeMajor(String code) {
        return (majorRepository.findOneByMajorCode(code)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Major không tồn tại mã: " + code);
                }));
    }
    public Major findMajorById(Long id) {
        return (majorRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Major không tồn tại mã: " + id);
                }));
    }
    public Subject findBySubjectId(Long id) {
        return (subjectRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Subject không tồn tại mã: " + id);
                }));
    }

    public Register findRegisterById(Long id) {
        return registerRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Bảng Register không tồn tại Id: " + id);
                });
    }


    public Register findRegisterByStudentIdAndSubjectId(Long studentId, Long subjectId) {
        return registerRepository
                .findOneByStudentIdAndSubjectId(studentId, subjectId)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException
                            ("Bảng Register không tồn tại StudentId - SubjectId: "
                                    + studentId + " - " + subjectId);
                });
    }


    public StudentRequest findStudentRequestById(Long id) {
        return studentRequestRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Bảng StudentRequest không tồn tại Id: " + id);
                });
    }
    public StudentResponse findStudentResponseById(Long id) {
        return studentResponseRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Bảng StudentResponse không tồn tại Id: " + id);
                });
    }
    public Student findStudentByUsername(String username) {
        Student student = studentRepository.findStudentByUsername(username)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Không tìm thấy username: " + username
                    );
                });
        return student;
    }

    public Role findRoleByCode(String code) {
        Role role = roleRepository.findRoleByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Role: " + code + " không tồn tại"));
        return role;
    }


    public Student findStudentById(Long id) {
        Student student = studentRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Không tìm thấy Id: " + id
                    );
                });
        return student;
    }
    public StudentRequest findStudentRequestByUsernameAndSubjectIdAndStatus(String username, Long subjectId, Boolean status) {
        StudentRequest studentRequest =
                studentRequestRepository
                .findOneByStudentRequestUsernameAndSubjectRequestIdAndStatus(username, subjectId, status)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Không tìm thấy Username - SubjectId: " + username + " - " + subjectId
                    );
                });
        return studentRequest;
    }
    public List<Student> findAllStudentByCourseId(Long courseId) {
         return studentRepository.findAllByCourseId(courseId);
    }
    public List<Semester> findAllSemester() {
        return semesterRepository.findAll();
    }
    public Semester findSemesterById(Long id) {
        return semesterRepository.findOne(id);
    }

    public Course findCourseById(Long id) {
        return courseRepository.findOne(id);
    }
    public List<Subject> findAllSubjectByMajorId(Long majorid) {
        return subjectRepository.findAllByMajorId(majorid);
    }
    public SchoolYear findSchoolYearById(Long id) {
        return schoolYearRepository.findOne(id);
    }
    public RegisterOfMajor findRegisterOfMajorByMajorId(Long majorId) {
        return registerOfMajorRepository.findOneByMajorId(majorId)
        .orElseThrow(() -> {
            return new ResourceNotFoundException("Không tìm thấy Bản ghi của Mã ngành: " + majorId);
        });
    }

    public List<Subject> findAllSubjectByMajorIdOfRegisterOfMajor(Long majorId) {
        return findRegisterOfMajorByMajorId(majorId).getSubjects();
    }


}
