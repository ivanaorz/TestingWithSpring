package com.example.testingwithspring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CarDetails {
    private List<Car> cars;
    private Car latestCar;
}
