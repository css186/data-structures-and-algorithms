package HashTables;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Axel", "Wil", 64.32, 122.39, 24.78);
        Person person2 = new Person("Kaipo", "Valens", 64.32, 122.39, 24.78);

        System.out.println("Axel's hash code: " + person1.hashCode());
        System.out.println("Kaipo's hash code: " + person2.hashCode());
        


    }
}
