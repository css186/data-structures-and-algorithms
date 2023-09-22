package HashTables;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private double height;
    private double weight;
    private double age;

    public Person(String firstName, String lastName, double height, double weight, double age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (Double.compare(person.height, height) != 0) return false;
        if (Double.compare(person.weight, weight) != 0) return false;
        if (Double.compare(person.age, age) != 0) return false;

        if (!firstName.equals(person.firstName)) return false;

        return lastName.equals(person.lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, height, weight, age);
    }
}
