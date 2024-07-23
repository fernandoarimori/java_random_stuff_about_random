package com.example.poerapotty.model;

import java.math.BigDecimal;
import java.util.List;

public record ResultPortaPottyPostDto(
        String name,
        BigDecimal weight,
        Sex sexOrientation
) {
}
