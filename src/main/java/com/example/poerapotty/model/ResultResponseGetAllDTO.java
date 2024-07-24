package com.example.poerapotty.model;

import java.math.BigDecimal;
import java.util.List;

public record ResultResponseGetAllDTO(
        Long id,
        String name,
        BigDecimal weight,
        List<Camps> camps,
        List<Person> persons
) {
    public ResultResponseGetAllDTO(ResultPortaPotty savedOne) {
        this(savedOne.getId(), savedOne.getName(), savedOne.getWeight(), savedOne.getCamps(), savedOne.getPersons());
    }
}
