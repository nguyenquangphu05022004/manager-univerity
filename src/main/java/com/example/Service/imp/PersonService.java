package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.PersonConverter;
import com.example.dto.PersonDTO;
import com.example.entity.Major;
import com.example.entity.Person;
import com.example.entity.Role;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService implements GenericService<PersonDTO> {

    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public PersonDTO save(PersonDTO object) {
        Person person = null;

        Set<Role> roles = object
                .getRoles()
                .stream()
                .map((role) -> searchBy.findRoleByCode(role))
                .collect(Collectors.toSet());
        Major major = searchBy.findMajorById(object.getMajorId());
        if (object.getId() != null) {
            Person oldPerson = searchBy.findPersonById(object.getId());
            person = personConverter.toEntity(oldPerson, object);
        } else {
            person = personConverter.toEntity(object);
        }
        person = person
                .toBuilder()
                .roles(roles)
                .major(major)
                .password(encoder.encode(object.getPassword()))
                .build();
        return personConverter.toDto(personRepository.save(person));

    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<PersonDTO> list() {
        return null;
    }

  
}
