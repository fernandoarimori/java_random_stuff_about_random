package com.example.poerapotty.controller;

import com.example.poerapotty.model.ResultPortaPottyPostDto;
import com.example.poerapotty.service.ResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @PostMapping
    public ResponseEntity postResultCntrllr(@Valid @RequestBody ResultPortaPottyPostDto dto, UriComponentsBuilder builder) {
        return resultService.postResult(dto, builder);
    }

    @GetMapping
    public ResponseEntity getAllCntrllr(@PageableDefault(size = 5) Pageable pageable) {
        return resultService.getAll(pageable);
    }

    //    @GetMapping("/random")
//    public ResponseEntity<List<PersonDtoResponse>> getRandomPersonCntrllr(){
//        return resultService.result();
//    }
    @PutMapping("/random")
    public ResponseEntity resultCntrllr() {
        return resultService.result();
    }
}
