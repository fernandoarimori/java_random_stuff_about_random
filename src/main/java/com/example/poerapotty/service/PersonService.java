package com.example.poerapotty.service;

import com.example.poerapotty.model.Person;
import com.example.poerapotty.model.PersonDtoPost;
import com.example.poerapotty.model.PersonDtoResponse;
import com.example.poerapotty.model.PersonRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRespository respository;

    public ResponseEntity postPerson(@Valid  PersonDtoPost dto, UriComponentsBuilder builder){
        Person toPost = new Person(dto);
        Person postedInRep = respository.save(toPost);
        URI uri = builder.path("/person/{id}").buildAndExpand(postedInRep.getId()).toUri();
        return ResponseEntity.created(uri).body(new PersonDtoResponse(postedInRep));
    }

    public ResponseEntity<Page<PersonDtoResponse>> getAll(Pageable pageable) {
        Page<PersonDtoResponse> allGot =respository.findAll(pageable).map(PersonDtoResponse::new);
        return ResponseEntity.ok().body(allGot);
    }
    public ResponseEntity turnIntoConsumed(Long id){
        var foundOne = respository.getReferenceById(id);
        foundOne.turnIntoTrue();
        Person toPost =respository.save(foundOne);
        return ResponseEntity.ok().body(new PersonDtoResponse(toPost));
    }
}
