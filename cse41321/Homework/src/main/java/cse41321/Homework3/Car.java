package cse41321.Homework3;

import java.util.Objects;

public class Car {
    public String make;
    public String model;
    public int mpg; // Miles per gallon

    // Generate car class constructor
    public Car(String make, String model, int mpg) {
        this.make = make;
        this.model = model;
        this.mpg = mpg;
    }

    // Override object equal method to utilize comparing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return mpg == car.mpg && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    // Override object toString method to display in String
    @Override
    public String toString() {
        return "{" + make + ", " + model + ", " + mpg + "}";
    }
}

