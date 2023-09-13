package com.example.testingwithspring.service;
import org.springframework.stereotype.Service;
import com.example.testingwithspring.model.Car;

import java.util.List;
import java.util.Optional;


// CarService interface with CRUD methods
@Service
public interface CarService {
    Car saveCar(Car car);   //Create
    List<Car> getAllCars();   //Read
    Optional<Car> getCarById(long id);   //Read
    Car updateCar(Car updatedCar);    //Update
    void deleteCar(long id);    //Delete
}
