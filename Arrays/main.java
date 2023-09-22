package cse41321.Homework1;

import java.util.Random;

public class main {

    // Total Time Complexity: O(n^3)
    public static void main(String[] args) {                                // O(1)

        // Setting to allow fine-tuning the granularity of the readings
        int NUM_READINGS = 60;                                              // O(1)
        int INSERTS_PER_READINGS = 1000;                                    // O(1)

        // Setting constant variable of converting nanosecond to second
        double NANO_SECOND = 1000000000;                                    // O(1)

        // Start with an array containing one element, which will be zero
         int[] array = {0};                                                 // O(1)

        // Instantiate Random object
        Random random = new Random();                                       // O(1)

        // print out column title (Array Length, Second per Insert)
        System.out.println("Array Length" + "\t" + "Second per Insert");    // O(1)

        // Loop NUM_READINGS times
        for (int i = 1; i <= NUM_READINGS; i++) {                           // O(n)
            // Set up starting time
            long startTime = System.nanoTime();                             // O(1)

            for (int j = 1; j <= INSERTS_PER_READINGS; j++) {               // O(n)
                // Assign random int in range of 0 to length of array to index
                int index = random.nextInt(array.length);                   // O(1)

                // Assign random int to value
                int value = random.nextInt();                               // O(1)

                // Implement insert method
                array = Homework1.insert(array, index, value);              // O(n)
            }
            // Set up ending time
            long endTime = System.nanoTime();                               // O(1)
            double timePerInsert = ((endTime - startTime) / NANO_SECOND) / INSERTS_PER_READINGS;    // O(1)

            // print out the result in required format
            System.out.println(String.format("%12d", array.length)          // O(1)
                    + "\t\t" + String.format("%13.6f", timePerInsert));
        }

    }

}
