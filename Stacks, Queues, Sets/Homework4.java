package cse41321.Homework4;

import cse41321.containers.Stack;

public class Homework4 {

    public static void addLargeNumbers(String num1, String num2) {

        // Instantiate stacks for operand num1, operand num2 and result
        Stack<Character> operandStackOne = new Stack<>();
        Stack<Character> operandStackTwo = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        // Loop for each char and push into each operand stack
        for (int i = 0; i < num1.length(); i++) {
            operandStackOne.push(num1.charAt(i));
        }

        for (int j = 0; j < num2.length(); j++) {
            operandStackTwo.push(num2.charAt(j));
        }

        // Initialize variable for carry part of addition
        int carry = 0;
        // Initialize variable for sum of two numbers
        int sum;

        // while at least one of the operand stack is not empty
        while (!operandStackOne.isEmpty() || !operandStackTwo.isEmpty()) {

            // If one stack is empty, the sum will be another stack's top number + carry part
            if (operandStackOne.isEmpty()) {
                sum = Integer.parseInt(String.valueOf(operandStackTwo.pop())) + carry;

                // Push sum into result stack
                resultStack.push(sum);

                // Update carry number based on current sum
                carry = sum / 10;

            }

            else if (operandStackTwo.isEmpty()) {
                sum = Integer.parseInt(String.valueOf(operandStackOne.pop())) + carry;
                resultStack.push(sum);
                carry = sum / 10;

            // If both operand stack are not empty, sum will be the top numbers of two stacks + carry
            } else {
                sum = Integer.parseInt(String.valueOf(operandStackOne.pop()))
                        + Integer.parseInt(String.valueOf(operandStackTwo.pop()))
                        + carry;
                // Push only remainder into result stack
                resultStack.push(sum % 10);

                // Update carry number based on current sum
                carry = sum / 10;
            }

        }

        // Loop through the result stack to display the addition result the console
        String output = "";

        while (!resultStack.isEmpty()) {
            output = output + resultStack.pop();
        }

        System.out.println(output);
    }
}
