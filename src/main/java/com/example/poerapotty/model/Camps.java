package com.example.poerapotty.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Camps {
    NPC,
    IFBB,
    WBFF,
    ICN,
    NABBA,
    ANB;

    private static final List<Camps> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Camps randomLetter() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}


