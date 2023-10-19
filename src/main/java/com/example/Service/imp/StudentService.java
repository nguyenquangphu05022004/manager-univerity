package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.GenericConverter;
import com.example.converter.imp.StudentConverter;
import com.example.dto.MyUser;
import com.example.dto.StudentDTO;
import com.example.entity.Major;
import com.example.entity.Role;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.MajorRepository;
import com.example.repository.RoleRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("studentOfService")
public class StudentService implements GenericService<StudentDTO>,
        UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentConverter converter;
    @Autowired
    private GenericSearchBy searchBy;

    @Override
    public StudentDTO save(StudentDTO object) {
        Student student = new Student();
        Major major = searchBy.findMajorById(object.getMajorId());
        List<Role> roles = Arrays.stream(object.getRoles().split(","))
                .map((code) -> {
                    return searchBy.findRoleByCode(code);
                }).collect(Collectors.toList());

        if (object.getId() != null) {
            //update
            Student oldStudent = searchBy.findStudentById(object.getId());
            student = converter.toEntity(oldStudent, object);
        } else {
            //insert]
            student = converter.toEntity(object);
        }
        Student studentBuild = student
                                .toBuilder()
                                .major(major)
                                .roles(roles)
                                .build();
        return converter.toDto(studentRepository.save(studentBuild));
        // TODO: 8/24/2023
    }


    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            studentRepository.delete(id);
        }
        // TODO: 8/24/2023
    }

    @Override
    public List<StudentDTO> list() {
        List<Student> entityList = studentRepository.findAll();
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student entityStudent : entityList) {
            dtoList.add(converter.toDto(entityStudent));
        }
        return dtoList;
        // TODO: 8/24/2023
    }

    @Override
    public StudentDTO getById(Long id) {
        return null;
    }

    @Override
    public List<StudentDTO> getByCode(String code) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user = searchBy.findStudentByUsername(username);
        Collection<? extends GrantedAuthority> authorities
                = Arrays.stream(user.getRoles().toArray())
                .map((role) -> {
                    return new SimpleGrantedAuthority(role.toString());
                })
                .collect(Collectors.toList());
        MyUser myUser = new MyUser(user.getUsername(),
                user.getPassword(), true,
                true, true,
                true, authorities, user.getFullName());
        return myUser;
    }

}

