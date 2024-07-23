package com.example.poerapotty.controller;

import com.example.poerapotty.model.PersonRespository;
import com.example.poerapotty.model.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
    @Autowired
    private PersonRespository personRespository;
    @Autowired
    private ResultRepository resultRepository;
    @GetMapping
    public String helloWorld(){
        return "HelloWorld! dev tools testing";
    }

    @DeleteMapping("/destroy")
    public ResponseEntity destroy(){
        resultRepository.deleteAll();
        personRespository.deleteAll();
        return ResponseEntity.ok(HttpStatus.I_AM_A_TEAPOT);
    }
}
