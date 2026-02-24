import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeChecker {
    // UC7: Deque-Based Optimized Palindrome Checker
    public static void runUC7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== UC7: Deque-Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindromeDeque(input)) {
            System.out.println(" \"" + input + "\" is a palindrome.");
        } else {
            System.out.println(" \"" + input + "\" is not a palindrome.");
        }
    }
    private static boolean isPalindromeDeque(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        runUC7();
    }


}