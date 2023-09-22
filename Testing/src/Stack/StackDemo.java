package Stack;

import java.util.Stack;

/**
 * Uses of Stacks:
 * 1. undo/redo features in text editors
 * 2. moving back/forward through browser history
 * 3. backtracking algorithms (maze, file directories)
 * 4. calling functions (call stack)
 */

public class StackDemo {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // check is stack is empty
        // System.out.println(stack.empty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("Doom");
        stack.push("Borderlands");
        stack.push("FFVII");

        System.out.println(stack);

        // stack starts at 1
        System.out.println(stack.search("FFVII"));
        // ends at its length
        System.out.println(stack.search("Minecraft"));


        System.out.println(stack.empty());
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        String myGame = stack.pop();
        System.out.println(myGame);
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.search("Skyrim"));
        System.out.println(stack.search("Minecraft"));
        System.out.println(stack.search("Harry Potter"));

          // out of heap space
//        for (int i = 0; i < 1000000000; i++) {
//            stack.push("Super Mario");
//        }
//        System.out.println(stack);


    }
}
