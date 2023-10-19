package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.RegisterConverter;
import com.example.converter.imp.SubjectConverter;
import com.example.dto.RegisterDTO;
import com.example.entity.Group;
import com.example.entity.Register;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.GroupRepository;
import com.example.repository.RegisterRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterSubjectService implements GenericService<RegisterDTO> {

    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private RegisterConverter registerConverter;


    public RegisterDTO register(Long subjectId, Long groupId) {
        Student student = searchBy.findStudentByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName());
        Subject subject = searchBy.findBySubjectId(subjectId);
        Group group = searchBy.findByIdGroup(groupId);
        return registerConverter
                .toDto(registerRepository
                        .save(Register.builder()
                                .group(group)
                                .student(student)
                                .subject(subject)
                                .status(false)
                                .build()));
    }

    public RegisterDTO updateRecord(String username, Long oldSubjectId,
                                    Long newSubjectId) {
//        Student student = currentStudent(username);
//        Subject oldSubject = getSubjectById(oldSubjectId);
//        Subject newSubject = getSubjectById(newSubjectId);
//        student.getSubjects().remove(oldSubject);
//        student.getSubjects().add(newSubject);
//        studentRepository.save(student);
//        return RegisterDTO.builder().subjectDTO(subjectConverter.toDto(newSubject))
//                .studentDTO(studentConverter.toDto(student)).build();
        return null;
    }


    public List<RegisterDTO> getAllRecordOfStudent() {
        Student student = searchBy.findStudentByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        );
        List<Register> registers = registerRepository.findAllByStudentId(student.getId());
        return registerConverter.dtoList(registers);
    }


    @Override
    public RegisterDTO save(RegisterDTO object) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    public void delete(Long id) {
        registerRepository.deleteRegisterById(id);
    }

    @Override
    public List<RegisterDTO> list() {
        return null;
    }

    @Override
    public RegisterDTO getById(Long id) {
        return registerConverter.toDto(registerRepository.findOneById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Không bảng Register tồn tại Id: " + id);
                }));
    }

    @Override
    public List<RegisterDTO> getByCode(String code) {
        return null;
    }
}
