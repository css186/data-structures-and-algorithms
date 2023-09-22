public class GenericsDemo {
    public static void main(String[] args) {

        Printer<Integer> printInt = new Printer<>(23);

        printInt.print();

        Printer<String> printString = new Printer<>("Print a String");
        printString.print();

    }
}
