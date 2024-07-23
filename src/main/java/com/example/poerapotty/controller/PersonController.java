package com.example.poerapotty.controller;

import com.example.poerapotty.model.PersonDtoPost;
import com.example.poerapotty.model.PersonDtoResponse;
import com.example.poerapotty.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity postPersonCntrllr(@Valid @RequestBody PersonDtoPost dto, UriComponentsBuilder builder) {
        return personService.postPerson(dto, builder);
    }

    @GetMapping
    public ResponseEntity<Page<PersonDtoResponse>> getAllPerson(@PageableDefault(size = 5) Pageable pageable) {
        return personService.getAll(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity turnToTrueCntrllr(@PathVariable Long id){
        return personService.turnIntoConsumed(id);
    }
}
