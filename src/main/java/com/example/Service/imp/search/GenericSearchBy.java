package com.example.Service.imp.search;

import com.example.entity.*;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.*;
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
	@Autowired
	private SemesterRepository semesterRepository;
	@Autowired
	private TuitionRepository tuitionRepository;


	public Tuition findTuitionById(Long id) {
		return (Tuition)findById("Tuition", id, tuitionRepository);
	}
	
	public Semester findBySemesterId(Long id) {
		return (Semester)findById("semester", id, semesterRepository);
	}
	public Group findByIdGroup(Long id) {
		return (Group) findById("group", id, groupRepository);
	}

	public Major findByCodeMajor(String code) {
		return majorRepository.findOneByMajorCode(code).get();

	}

	public Major findMajorById(Long id) {
		return (Major) findById("major", id, majorRepository);
	}

	public RegisterOfMajor findRegisterOfMajorById(Long id) {
		return (RegisterOfMajor) findById("registerOfMajor", id, registerOfMajorRepository);
	}

	public Subject findBySubjectId(Long id) {
		return (Subject) findById("subject", id, subjectRepository);
	}

	public Register findRegisterById(Long id) {
		return (Register) findById("register", id, registerRepository);
	}

	public StudentRequestExchange findStudentRequestExchangeById(Long id) {
		return (StudentRequestExchange) findById("studentRequestExchange", id, studentRequestExchangeRepository);
	}

	public StudentExchangeRegister findStudentExchangeRegisterById(Long id) {
		return (StudentExchangeRegister) findById("studentExchangeRegister", id, studentExchangeRegisterRepository);
	}

	public Student findStudentByPersonId(Long personId) {
		return findPersonById(personId).getStudent();
	}

	public Person findPersonById(Long id) {
		return (Person) findById("person", id, personRepository);
	}

	public Role findRoleByCode(String code) {
		return  roleRepository.findRoleByCode(code).get();
	}

	public Student findStudentById(Long id) {
		return (Student) findById("student", id, studentRepository);
	}

	public List<Student> findAllStudentByCourseId(Long courseId) {
		return studentRepository.findAllByCourseId(courseId);
	}

	public Course findCourseById(Long id) {
		return (Course) findById("course", id, courseRepository);
	}

	public List<Subject> findAllSubjectByMajorId(Long majorid) {
		return subjectRepository.findAllByMajorId(majorid);
	}

	public SchoolYear findSchoolYearById(Long id) {
		return (SchoolYear) findById("schoolYear", id, schoolYearRepository);
	}

	public RegisterOfMajor findRegisterOfMajorByMajorId(Long majorId) {
		return registerOfMajorRepository.findOneByMajorId(majorId).get();
	}

	public Grade findGradeById(Long id) {
		return (Grade)findById("grade", id, gradeRepository);
	}

	public TimeTable findTimeTableById(Long id) {
		return (TimeTable)findById("timetable", id, timeTableRepository);
	}

	public ClassRoom findClassRoomById(Long id) {
		return (ClassRoom)findOneById("classroom", id, roomRepository);
	}

	public Person findPersonByUsername(String username) {
		return personRepository.findByUsername(username).get();
	}

	public Teacher findTeacherById(Long id) {
		return (Teacher)findById("teacher", id, teacherRepository);
	}

	public static Object findOneById(String className, Long id, JpaRepository repository) {
		Object object = repository.findOne(id);
		if (object != null) {
			return object;
		}
		throw new ResourceNotFoundException(className + " không tồn tại Id: " + id);
	}
	private Object findById(String className, Long id, JpaRepository repository) {
		Object object = repository.findOne(id);
		if (object != null) {
			return object;
		}
		throw new ResourceNotFoundException(className + " không tồn tại Id: " + id);
	}

}
