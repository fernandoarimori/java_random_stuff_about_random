package com.example.poerapotty.service;

import com.example.poerapotty.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final PersonRespository personRespository;

    public ResponseEntity postResult(ResultPortaPottyPostDto dto, UriComponentsBuilder builder) {
        ResultPortaPotty toPost = new ResultPortaPotty(dto);
        ResultPortaPotty savedOne = resultRepository.save(toPost);
        URI uri = builder.path("results/{id}").buildAndExpand(savedOne.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResultResponseDTO(savedOne));
    }

    public ResponseEntity<Page<ResultResponseDTO>> getAll(Pageable pageable) {
        var allFound = resultRepository.findAll(pageable).map(ResultResponseDTO::new);
        return ResponseEntity.ok(allFound);
    }

    public ResponseEntity result() {
        var foundRandoms = personRespository.findRandom();
        System.out.println(foundRandoms.size());
        var result = resultRepository.findRandom();
        Integer sizeRule = 3;
        if (foundRandoms.size()>sizeRule){
            return ResponseEntity.badRequest().body(">3");
        }
        foundRandoms.forEach(
                random->{
                    random.turnIntoTrue();
                    random.setResult(result);
                    personRespository.save(random);
                }
        );
        result.setPersons(foundRandoms);
        ResultPortaPotty updatedOne = resultRepository.save(result);
        return ResponseEntity.ok().body(new ResultResponseDTO(updatedOne));
    }
}
