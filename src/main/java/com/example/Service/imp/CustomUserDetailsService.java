package com.example.Service.imp;

import com.example.Service.imp.search.GenericSearchBy;
import com.example.dto.MyUser;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customUserdetails")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private GenericSearchBy searchBy;

    @Override
    public MyUser loadUserByUsername(String username) {
        Person user = searchBy.findPersonByUsername(username);
        List<GrantedAuthority> authorities
                = user.getRoles()
                .stream()
                .map((r) -> new SimpleGrantedAuthority("ROLE_"+r.getCode()))
                .collect(Collectors.toList());

        MyUser myUser = new MyUser(user.getUsername(),
                user.getPassword(), true,
                true, true,
                true, authorities, user.getFullName());
        return myUser;
    }
}
