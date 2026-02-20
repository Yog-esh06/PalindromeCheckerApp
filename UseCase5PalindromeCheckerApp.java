import java.util.Stack;

/**
 * MAIN CLASS UseCase5PalindromeCheckerApp
 *
 * Use Case 5: Stack Based Palindrome Checker
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * Pushes characters into a stack
 * Pops them in reverse order
 * Compares with original sequence
 * Displays the result
 *
 * @author Developer
 * @version 5.0
 */
public class UseCase5PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "noon";

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Build reversed string using stack
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original and reversed
        if (input.equals(reversed)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}