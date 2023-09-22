package cse41321.Homework1;

public class Homework1 {

    // implementation of insert method
    // Total Time Complexity: O(n)
    static int[] insert(int[] array, int index, int value) {                            // O(1)

        // Create a new array with one element larger than the original array
        int[] newArray = new int[array.length + 1];                                     // O(1)

        // Copy the elements from the original array to the new array
        // (starting from index 0 to the index where the value needs to be inserted)
        for (int i = 0; i < index; i++) {                                               // O(n)
            newArray[i] = array[i];                                                     // O(1)
        }

        // Assign value to the required index of the new array
        newArray[index] = value;                                                        // O(1)

        // Loop the rest of the elements from the original array to the new array
        // (starting from index + 1 and ends at length of array
        for (int j = index; j < array.length; j++) {                                    // O(n)
            newArray[j + 1] = array[j];                                                 // O(1)
        }

        // Return the result
        return newArray;                                                                // O(1)

    }

}