package cse41321.Homework3;

import java.util.Comparator;

public class CompareCarsByMakeThenDescendingMPG implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        if (!car1.make.equals(car2.make)) {
            return car1.make.compareTo(car2.make);
        }
        else {
            return car2.mpg - car1.mpg;
        }
    }
}
