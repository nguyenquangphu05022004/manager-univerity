package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.PersonDTO;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonConverter implements GenericConverter<Person, PersonDTO> {

    @Override
    public Person toEntity(PersonDTO dto) {
        return Person
                .builder()
                .birthOfDate(dto.getBirthOfDate())
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .username(dto.getUsername())
                .id(dto.getId())
                .build();
    }

    @Override
    public PersonDTO toDto(Person entity) {
        return PersonDTO
                .builder()
                .birthOfDate(entity.getBirthOfDate())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .username(entity.getUsername())
                .id(entity.getId())
                .build();
    }

    @Override
    public Person toEntity(Person entity, PersonDTO dto) {
        return null;
    }

    @Override
    public PersonDTO toDto(PersonDTO dto, Person entity) {
        return null;
    }

    @Override
    public List<PersonDTO> dtoList(List<Person> entityList) {
        return null;
    }
}
