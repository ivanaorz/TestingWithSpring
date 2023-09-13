package com.example.testingwithspring.model;
import jakarta.persistence.*;
import lombok.*;


@Data //enables getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity //enables JPA

//@Table(name = "cars")
public class Car {

//    public Car(String carModel, String year, String carPlate, String carOwner) {
//        this.carModel = carModel;
//        this.year = year;
//        this.carPlate = carPlate;
//        this.carOwner = carOwner;
//    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //        @Column(name = "car_model", nullable = false)
    private String carModel;

    //        @Column(name = "year", nullable = false)
    private String year;

    //        @Column(name = "car_plate", nullable = false)
    private String carPlate;

    //        @Column(name = "car_owner", nullable = false)
    private String carOwner;

}
