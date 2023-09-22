package cse41321.Homework7;

import java.util.Comparator;

class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}


public class Homework7 {

    public static <E> void outputSorted(Person[] people, Comparator<Person> comparator) {
        // Create a new Heap instance with the given comparator
        Heap<Person> heap = new Heap<>(comparator);

        // Insert each person into the heap
        for (Person person : people) {
            heap.insert(person);
        }

        // Extract and output each person from the heap
        while (!heap.isEmpty()) {
            Person extractedPerson = heap.extract();
            System.out.print(extractedPerson.getName() + ", " + extractedPerson.getAge() + ", "
                    + extractedPerson.getHeight());
            System.out.print("\t");
        }
    }

    public static void main(String[] args) {
        // Example usage
        Person[] people = {
                new Person("Alice", 30, 180.7),
                new Person("Chuck", 25, 169.6),
                new Person("Bob", 35, 170.4),
                new Person("Zack", 60, 159.6),
                new Person("George", 40, 188.8)
        };
        // Sorted by ascending name
        System.out.println("Sorted by Ascending Name");
        Comparator<Person> compareName = Comparator.comparing(Person::getName);
        outputSorted(people, compareName);
        System.out.println();

        // Sorted by ascending age
        System.out.println("Sorted by Ascending Age");
        Comparator<Person> compareAge = Comparator.comparing(Person::getAge);
        outputSorted(people, compareAge);
        System.out.println();

        // Sorted by ascending height
        System.out.println("Sorted by Ascending Height");
        Comparator<Person> compareHeight = Comparator.comparing(Person::getHeight);
        outputSorted(people, compareHeight);
        System.out.println();

    }


}
