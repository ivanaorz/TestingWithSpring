package com.example.testingwithspring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testingwithspring.model.Car;
import com.example.testingwithspring.repository.CarRepository;
import com.example.testingwithspring.service.CarService;
import com.example.testingwithspring.exception.DuplicateCarException;



import java.util.List;
import java.util.Optional;

// CarServiceIMPL that implements carService interface
@Service
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public Car saveCar(Car car) {
        // Check if a car with the same plate already exists
        if (carRepository.existsByCarPlate(car.getCarPlate())) {
            throw new DuplicateCarException("A car with the same plate already exists.");
        }
        // If no duplicate is found, proceed with saving the car
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carRepository.findById(id);
    }
    @Override
    public Car updateCar(Car updatedCar) {
        return carRepository.save(updatedCar);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

}
