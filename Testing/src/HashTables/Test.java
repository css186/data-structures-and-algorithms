package HashTables;

public class Test {

    public static int fmod(double a, double b) {

        double hashValue = a * 0.618;
        double fraction = hashValue - Math.floor(hashValue);
        int index = (int) Math.floor(2000 * fraction);

        return index;
    }

    public static void main(String[] args) {

        System.out.println(fmod(6341, 1.0));
    }
}
