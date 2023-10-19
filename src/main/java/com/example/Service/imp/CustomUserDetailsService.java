package com.example.Service.imp;

import com.example.dto.MyUser;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service("customUserdetails")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository userRepository;

    @Override
    public MyUser loadUserByUsername(String username) {
        Student user = userRepository.findStudentByUsername(username)
                .orElseThrow(() -> {
                    return
                          new  ResourceNotFoundException("Username :" + username + " : không tồn tại");
                });
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
