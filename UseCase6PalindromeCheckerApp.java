import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * MAIN CLASS UseCase6PalindromeCheckerApp
 *
 * Use Case 6: Queue + Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using both
 * Queue (FIFO) and Stack (LIFO) data structures.
 *
 * At this stage, the application:
 * Enqueues characters into a queue
 * Pushes characters into a stack
 * Compares dequeue (FIFO) with pop (LIFO)
 * Displays the result
 *
 * @author Developer
 * @version 6.0
 */
public class UseCase6PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        String input = "level";

        // Create Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}
