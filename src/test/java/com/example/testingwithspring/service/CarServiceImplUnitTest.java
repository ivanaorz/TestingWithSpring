package com.example.testingwithspring.service;

import com.example.testingwithspring.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.testingwithspring.model.Car;
import com.example.testingwithspring.exception.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


//This annotation enables Mockito extensions for the testing class
@ExtendWith(MockitoExtension.class)
class CarServiceImplUnitTest {
    // Fields for dependencies and test data

    // Mocking the carRepository
    @Mock
    private CarRepository carRepository;

    //Class we are testing
    @InjectMocks
    private CarServiceImpl carService;

    //Test data
    private Car carOne;
    private Car carTwo;


    //Initializing dependencies or test data

    //This annotation indicates that the method setUp() will be executed before each test method
    @BeforeEach
    public void setUp() {
        //Creating a car object for carOne
        carOne = Car.builder()
                .carModel("Porche")
                .carPlate("MGM 720")
                .year("2022")
                .carOwner("Karl Anderson")
                .build();

        //Creating a car object for carTwo
        carTwo = Car.builder()
                .carModel("Mustang")
                .carPlate("TRS 550")
                .year("2010")
                .carOwner("Tom Isberg")
                .build();

    }

    //The testing part
    @DisplayName("JUnit test for saveCar method")
    @Test
    void saveCar_Should_Return_TheExpectedCar() {
        // Arrange: Defining the behavior of the mocked carRepository
        when(carRepository.save(any(Car.class))).thenReturn(carOne);

        // Act: Calling the saveCar method with a valid Car object (expected one)
        Car savedCar = carService.saveCar(carOne);

        // Assert: Verifying that the save method was called with the expected Car object
        verify(carRepository, times(1)).save(carOne);

        // Assert: Verifying that the returned Car object(savedCar) is the same as the one we expected to save(carOne)
        assertEquals(carOne, savedCar);
    }
    @Test
    void saveCar_Should_Return_NonNullCar() {
        // Arrange
        when(carRepository.save(any(Car.class))).thenReturn(carOne);

        // Act
        Car savedCar = carService.saveCar(carOne);

        // Assert
        assertThat(savedCar).isNotNull();
    }
    @Test
    void saveCar_Should_ThrowException_If_TheSameCarPlateExists() {
        //Arrange:  Simulating that a car with the same plate already exists in the repository
        //Act part is implicitly in the Arrange part
        String duplicatePlate = "MGM 720";
        when(carRepository.existsByCarPlate(duplicatePlate)).thenReturn(true);

        // Assert: Checking if an exception is thrown when a duplicate car is encountered
        assertThrows(DuplicateCarException.class, () -> carService.saveCar(carOne));

        // Assert: Verifying that the save method of carRepository is not called,
        // so that it doesn't save a duplicate car
        verify(carRepository, never()).save(any(Car.class));
    }


    @Test
    void getAllCars() {
    }

    @Test
    void getCarById() {
    }

    @Test
    void updateCar() {
    }

    @Test
    void deleteCar() {
    }
}