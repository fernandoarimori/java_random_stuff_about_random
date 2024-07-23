package com.example.poerapotty.model;

import java.math.BigDecimal;
import java.util.List;

public record ResultResponseDTO(
        String name,
        BigDecimal weight,
        List<Camps> camps,
        List<Person> persons
) {
    public ResultResponseDTO(ResultPortaPotty savedOne) {
        this(savedOne.getName(), savedOne.getWeight(), savedOne.getCamps(), savedOne.getPersons());
    }
}
