package cse41321.Homework3;

import java.util.Comparator;

public class CompareCarsByDescendingMPG implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        return car2.mpg - car1.mpg;
    }
}
