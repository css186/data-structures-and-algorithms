package cse41321.Homework2;

import cse41321.containers.SinglyLinkedList;


import java.util.ArrayList;
import java.util.List;

/**
 * This program represent a polynomial by using a singly linked list.
 * Each element in the linked list represents one of the terms in the polynomial.
 *
 * Program Output
 * Test1: x + 1.0 with x = 1.0
 * Display: 1.0x + 1.0
 * Evaluate: 2.0
 * ---
 * Test2: x^2 - 1.0 with x = 2.03
 * Display: 1.0x^2 - 1.0
 * Evaluate: 3.1209
 * ---
 * Test3: -3.0x^3 + 0.5x^2 - 2.0x with x = 05.0
 * Display: -3.0x^3 + 0.5x^2 - 2.0x
 * Evaluate: -372.5
 * ---
 * Test4: -0.3125x^4 - 9.915x^2 - 7.75x - 40.0 with x = 123.45
 * Display: -0.3125x^4 - 9.915x^2 - 7.75x - 40.0
 * Evaluate: -72731671.6863
 */

public class Homework2 {

    public static void main(String[] args) {
        // Test 1
        System.out.println("Test1: x + 1.0 with x = 1.0");
        SinglyLinkedList<Double> polynomial_1 = new SinglyLinkedList<Double>();
        appendTerm(polynomial_1, 1.0);
        appendTerm(polynomial_1, 1.0);
        System.out.print("Display: ");
        display(polynomial_1);
        System.out.println("Evaluate: " + evaluate(polynomial_1, 1.0));
        System.out.println("---");

        // Test 2
        System.out.println("Test2: x^2 - 1.0 with x = 2.03");
        SinglyLinkedList<Double> polynomial_2 = new SinglyLinkedList<Double>();
        appendTerm(polynomial_2, 1.0);
        appendTerm(polynomial_2, 0.0);
        appendTerm(polynomial_2, -1.0);
        System.out.print("Display: ");
        display(polynomial_2);
        System.out.println("Evaluate: " + String.format("%.4f",evaluate(polynomial_2, 2.03)));
        System.out.println("---");

        // Test 3
        System.out.println("Test3: -3.0x^3 + 0.5x^2 - 2.0x with x = 05.0");
        SinglyLinkedList<Double> polynomial_3 = new SinglyLinkedList<Double>();
        appendTerm(polynomial_3, -3.0);
        appendTerm(polynomial_3, 0.5);
        appendTerm(polynomial_3, -2.0);
        appendTerm(polynomial_3, 0.0);
        System.out.print("Display: ");
        display(polynomial_3);
        System.out.println("Evaluate: " + evaluate(polynomial_3, 05.0));
        System.out.println("---");

        // Test 4
        System.out.println("Test4: -0.3125x^4 - 9.915x^2 - 7.75x - 40.0 with x = 123.45");
        SinglyLinkedList<Double> polynomial_4 = new SinglyLinkedList<Double>();
        appendTerm(polynomial_4, -0.3125);
        appendTerm(polynomial_4, 0.0);
        appendTerm(polynomial_4, -9.915);
        appendTerm(polynomial_4, -7.75);
        appendTerm(polynomial_4, -40.0);
        System.out.print("Display: ");
        display(polynomial_4);
        System.out.println("Evaluate: " + String.format("%.4f", evaluate(polynomial_4, 123.45)));
        System.out.println("---");

    }

    // this method insert the coefficient of polynomial from the tail
    private static void appendTerm(SinglyLinkedList<Double> polynomial, Double coefficient) {
        polynomial.insertTail(coefficient);

    }

    // method to get the head of the singly linked list and display into polynomial format
    private static void display(SinglyLinkedList<Double> polynomial) {
        SinglyLinkedList<Double>.Element element = polynomial.getHead();

        // get the element of the linked list(polynomial) and store it an arraylist in order
        List<Double> coefficientList = new ArrayList<Double>();
        while (element != null) {
            coefficientList.add(element.getData());
            element = element.getNext();
        }

        // set initial output string
        String output = "";

        // loop trough coefficient list to append output
        for (int i = 0; i < coefficientList.size(); i++) {
            // append the first element without considering the sign
            if (i == 0) {
                output = output + coefficientList.get(0) + "x^" + (coefficientList.size() - 1 - i);
            }
            // append the last element without x
            else if (i == coefficientList.size() - 1) {
                if (coefficientList.get(i) > 0) {
                    output = output + " + " + coefficientList.get(i);
                }
                else if (coefficientList.get(i) < 0) {
                    output = output + " - " + (-coefficientList.get(i));
                }
                // ignore zero
            }
            // if i equals 1, then append x only(instead of append x^1)
            else if (i == coefficientList.size() - 2) {
                if (coefficientList.get(i) > 0) {
                    output = output + " + " + coefficientList.get(i) + "x";
                }
                else if (coefficientList.get(i) < 0) {
                    output = output + " - " + (-coefficientList.get(i)) + "x";
                }
            }

            // other elements beside the first one and the last one
            else {
                if (coefficientList.get(i) > 0) {
                    output = output + " + " + coefficientList.get(i) + "x^" + (coefficientList.size() - 1 - i);
                }
                else if (coefficientList.get(i) < 0) {
                    output = output + " - " + (-coefficientList.get(i)) + "x^" + (coefficientList.size() - 1 - i);
                }
            }

        }
        // display final output in string
        System.out.println(output);
    }

    // this method will calculate the result of a given polynomial and a give x value
    private static Double evaluate(SinglyLinkedList<Double> polynomial, Double x) {
        SinglyLinkedList<Double>.Element element = polynomial.getHead();

        // get the element of the linked list(polynomial) and store it an arraylist in order
        List<Double> coefficientList = new ArrayList<Double>();
        while (element != null) {
            coefficientList.add(element.getData());
            element = element.getNext();
        }
        double total = 0.0;

        // loop the coefficient list and calculate the result
        for (int i = 0; i < coefficientList.size(); i++) {
            // get the exponent of x
            int exponent = coefficientList.size() - 1 - i;
            total = total + coefficientList.get(i) * Math.pow(x, exponent);

        }

        // return the result
        return total;
    }

}
