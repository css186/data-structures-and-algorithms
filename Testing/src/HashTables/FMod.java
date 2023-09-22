package HashTables;

public class FMod {

    public static double fmod(double a, double b){
        int result = (int) Math.floor(a / b);
        return a - result * b;
    }
}
