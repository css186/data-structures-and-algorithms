import static java.util.Arrays.sort;

public class BinarySearchDemo {

    public static int binarySearch(int[] array, int number) {
        int lowerIndex = 0;
        int upperIndex = array.length - 1;

        // start searching
        // 0 1 2 -> len 3 middle 1
        // 0 1 2 3 -> len 4 middle

        while (lowerIndex <= upperIndex) {
            int middleIndex = (lowerIndex + upperIndex) / 2;

            if (number < array[middleIndex]) {
                upperIndex = middleIndex - 1;
            }
            else if (number > array[middleIndex]) {
                lowerIndex = middleIndex + 1;
            }
            else {
                return middleIndex;
            }
        }
        // not found, return -1
        return -1;
    }

    public static int simpleSearch(int[] array, int number) {

        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        final double NANO_SECOND = 1000000000;
        int[] array = {99, 55, 44, 3, 1, 44, 66, 87, 90, 52, 36, 40};

        // array should be sorted before binary search
        sort(array);

        long start = System.nanoTime();
        int result = binarySearch(array, 80);
        System.out.println(result);
        long end = System.nanoTime();

        double duration = (end - start) / NANO_SECOND;

        long start2 = System.nanoTime();
        int result2 = simpleSearch(array, 80);
        System.out.println(result2);
        long end2 = System.nanoTime();

        double duration2 = (end2 - start2) / NANO_SECOND;

        System.out.println("Operation1 spent: " + duration + " seconds");
        System.out.println("Operation2 spent: " + duration2 + " seconds");



    }

}
