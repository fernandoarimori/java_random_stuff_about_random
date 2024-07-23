package com.example.poerapotty.model;

import java.math.BigDecimal;

public record PersonDtoResponse(
        Long id,
        String name,
        String email,
        BigDecimal weight,
        Sex sexOrientation,
        ResultPortaPotty resultPortaPotty) {
    public PersonDtoResponse(Person postedInRep) {
        this(postedInRep.getId(), postedInRep.getName(), postedInRep.getEmail(), postedInRep.getWeight(), postedInRep.getSexOrientation(), postedInRep.getResult());
    }
}
