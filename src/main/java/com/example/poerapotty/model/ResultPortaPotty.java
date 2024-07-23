package com.example.poerapotty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity(name = "Result")
@Table(name = "tb_result")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ResultPortaPotty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Positive
    @NotNull
    private BigDecimal weight;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Sex sexOrientation;
    @Enumerated(EnumType.STRING)
    private List<Camps> camps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "result")
    @JsonIgnore
    private List<Person> persons;

    public ResultPortaPotty(ResultPortaPottyPostDto dto) {
        this.name = dto.name();
        this.weight = dto.weight();
        this.sexOrientation = dto.sexOrientation();
        this.camps = pickCamps();
        System.out.println(this.camps);
    }

    private static List<Camps> pickCamps() {
        Integer min = 1;
        Integer max = 7;
        Random randomSize = new Random();
        Integer theSize = randomSize.nextInt(min, max);
        List<Camps> camps = new ArrayList<>();
        int i;
        for (i = 0; i < theSize; i++) {
            Camps pickedOne = Camps.randomLetter();
            if (camps.contains(pickedOne)) {
                i = i - 1;
            } else {
                camps.add(pickedOne);
            }
        }
        return camps;
    }

}
