package cse41321.Homework3;

import cse41321.algorithms.QuickSort;

public class Homework3 {

    public static void main(String[] args) {

        // Instantiate car objects according to the instruction from hw3
        Car c1 = new Car("Toyota", "Camry", 33);
        Car c2 = new Car("Ford", "Focus", 40);
        Car c3 = new Car("Honda", "Accord", 34);
        Car c4 = new Car("Ford", "Mustang", 31);
        Car c5 = new Car("Honda", "Civic", 39);
        Car c6 = new Car("Toyota", "Prius", 48);
        Car c7 = new Car("Honda", "Fit", 35 );
        Car c8 = new Car("Toyota", "Corolla", 35);
        Car c9 = new Car("Ford", "Taurus", 28);

        // Add car object according to the instruction's order
        Car[] cars = {c1, c2, c3, c4, c5, c6, c7, c8, c9};

        // Display the original unsorted order
        System.out.println("Display Unsorted Order:");
        display(cars);
        System.out.println("---");

        // Invoke sortByMakeThenModel method to sort
        sortByMakeThenModel(cars);

        // Invoke sortByDescendingMPG method to sort
        sortByDescendingMPG(cars);

        // Invoke sortMakeThenDescending method to sort
        sortMakeThenDescendingMPG(cars);


    }

    public static void display(Car[] cars) {

        String result = "[";

        for (int i = 0; i < cars.length - 1; i++) {
            result = result + cars[i] + ", ";
        }

        result = result + cars[cars.length - 1] + "]";

        System.out.println(result);
    }

    public static void sortByMakeThenModel(Car[] cars) {
        // Instantiate CompareCarsByMakeThenModel object
        CompareCarsByMakeThenModel makeThenModel = new CompareCarsByMakeThenModel();

        // Use quickSort method provided in starting code
        QuickSort.quickSort(cars, makeThenModel);

        System.out.println("Display Sorted Cars by Make then Model:");
        display(cars);
        System.out.println("---");

    }

    public static void sortByDescendingMPG(Car[] cars) {
        // Instantiate CompareCarsByDescendingMPG object
        CompareCarsByDescendingMPG descendingMPG = new CompareCarsByDescendingMPG();

        // Use quickSort method provided in starting code
        QuickSort.quickSort(cars, descendingMPG);

        System.out.println("Display Sorted Cars by Descending MPG:");
        display(cars);
        System.out.println("---");

    }

    public static void sortMakeThenDescendingMPG(Car[] cars) {
        // Instantiate CompareCarsByMakeThenDescendingMPG object
        CompareCarsByMakeThenDescendingMPG makeThenDescendingMPG = new CompareCarsByMakeThenDescendingMPG();

        // Use quickSort method provided in starting code
        QuickSort.quickSort(cars, makeThenDescendingMPG);

        System.out.println("Display Sorted Cars by Make then Descending MPG:");
        display(cars);
        System.out.println("---");

    }


}

