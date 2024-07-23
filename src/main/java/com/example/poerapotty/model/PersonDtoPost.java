package com.example.poerapotty.model;

import java.math.BigDecimal;

public record PersonDtoPost(
        String name,
        String email,

        BigDecimal weight,
        Sex sexOrientation
) {
}
