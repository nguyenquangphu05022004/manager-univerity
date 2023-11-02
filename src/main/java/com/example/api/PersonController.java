package com.example.api;

import com.example.Service.imp.PersonService;
import com.example.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @PostMapping("/api/persons")
    public PersonDTO add(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO);
    }
}
