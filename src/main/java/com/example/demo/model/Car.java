package com.example.demo.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "model_of_car")
    private String model_of_car;
    @Column ( name = "brand_car")
    private String brand_car;
    @Column (name = "power")
    private int power;

}
