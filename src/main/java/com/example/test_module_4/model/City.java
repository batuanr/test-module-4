package com.example.test_module_4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(1)
    private double area;
    @Min(1)
    private double population;
    @Min(1)
    private double GDP;
    private String description;
    @ManyToOne
    private Nation nation;
}
