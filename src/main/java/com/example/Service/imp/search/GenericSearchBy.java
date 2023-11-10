package com.example.Service.imp.search;

import com.example.entity.*;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.*;
import com.example.repository.blog.BlogRepository;
import com.example.repository.blog.CategoryRepository;
import com.example.repository.blog.PostNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericSearchBy {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private StudentRequestExchangeRepository studentRequestExchangeRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentExchangeRegisterRepository studentExchangeRegisterRepository;
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
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public static Object findOneById(
            String className,
            Long id,
            JpaRepository repository
    )  {
            Object object = repository.findOne(id);
            if(object != null) {
                return object;
            } else {
                throw new ResourceNotFoundException(className + " không tồn tại Id: " + id);
            }
    }


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

    public RegisterOfMajor findRegisterOfMajorById(Long id) {
        return (registerOfMajorRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("RegisterOfMajor không tồn tại mã: " + id);
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


    public StudentRequestExchange findStudentRequestExchangeById(Long id) {
        return studentRequestExchangeRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Bảng StudentRequestExchange không tồn tại Id: " + id);
                });
    }

    public StudentExchangeRegister findStudentExchangeRegisterById(Long id) {
        return studentExchangeRegisterRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Bảng StudentExchangeRegister không tồn tại Id: " + id);
                });
    }

    public Student findStudentByPersonId(Long personId) {
        Student student = studentRepository.findOneByPerson(personId)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Không tìm thấy username: " + personId);
                });
        return student;
    }

    public Person findPersonById(Long id) {
        Person person = personRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Không tìm thấy person: " + id);
                });
        return person;
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
                            "Không tìm thấy Id: " + id);
                });
        return student;
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

    public Grade findGradeById(Long id) {
        return gradeRepository.findOneById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Không tìm thấy Grade có id: " + id));
    }

    public TimeTable findTimeTableById(Long id) {
        return timeTableRepository.findOneById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Không tìm thấy TimeTable có id: " + id));
    }

    public ClassRoom findClassRoomById(Long id) {
        return roomRepository.findOneById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Không tìm thấy Room: " + id));
    }

    public Person findPersonByUsername(String username) {
        return personRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Không tìm thấy Person: " + username)
                );
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepository
                .findOneById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Không tìm thấy Teacher: " + id)
                );
    }
}
