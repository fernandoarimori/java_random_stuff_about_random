package com.example.poerapotty.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Person")
@Table(name = "tb_person")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Blank entity")
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotNull
    @DecimalMin("0.0")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal weight;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sexOrientation;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "result")
    private ResultPortaPotty result;
    private Boolean consumed;

    public Person(PersonDtoPost dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.weight = dto.weight();
        this.sexOrientation = dto.sexOrientation();
        this.consumed = false;
    }

    public void turnIntoTrue() {
        this.consumed = true;
    }

    public void setResult(ResultPortaPotty result) {
        this.result = result;
    }
}
