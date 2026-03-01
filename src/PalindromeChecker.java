import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return check(clean, 0, clean.length() - 1);
    }
    private boolean check(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return check(str, s + 1, e - 1);
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean checkPalindrome(String str) {
        if (strategy == null) return false;
        return strategy.isPalindrome(str);
    }
}
public class PalindromeChecker {
    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; this.next = null; }
    }

    public static void runUC7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== UC7: Deque-Based Palindrome Checker ===");
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        System.out.println("Result: " + isPalindromeDeque(input));
    }

    private static boolean isPalindromeDeque(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void runUC8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        System.out.println("Result: " + isPalindromeLinkedList(input));
    }

    private static boolean isPalindromeLinkedList(String str) {
        if (str == null || str.isEmpty()) return true;
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Node head = null, tail = null;
        for (char ch : str.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) { head = newNode; tail = newNode; }
            else { tail.next = newNode; tail = newNode; }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next; secondHalf = secondHalf.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next; curr.next = prev; prev = curr; curr = next;
        }
        return prev;
    }

    public static void runUC9() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== UC9: Recursive Palindrome Checker ===");
        System.out.print("Enter string: ");
        String input = scanner.nextLine();
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("Result: " + isPalindromeRecursive(clean, 0, clean.length() - 1));
    }

    private static boolean isPalindromeRecursive(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return isPalindromeRecursive(str, s + 1, e - 1);
    }

    public static void runUC10() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== UC10: Case-Insensitive & Space-Ignored ===");
        System.out.print("Enter phrase: ");
        String input = scanner.nextLine();
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("Result: " + isPalindromeRecursive(normalized, 0, normalized.length() - 1));
    }

    public static void runUC11() {
        System.out.println("\n=== UC11: Object-Oriented Service ===");
        PalindromeService service = new PalindromeService();
        service.setStrategy(new DequeStrategy());
        System.out.println("Service Check ('radar'): " + service.checkPalindrome("radar"));
    }

    public static void runUC12() {
        System.out.println("\n=== UC12: Strategy Pattern Swapping ===");
        PalindromeService service = new PalindromeService();
        service.setStrategy(new RecursiveStrategy());
        System.out.println("Using Recursive: " + service.checkPalindrome("madam"));
        service.setStrategy(new DequeStrategy());
        System.out.println("Using Deque: " + service.checkPalindrome("madam"));
    }

    public static void runUC13() {
        System.out.println("\n=== UC13: Performance Comparison ===");
        String test = "a".repeat(1000) + "b" + "a".repeat(1000);
        
        long start, end;

        start = System.nanoTime();
        isPalindromeDeque(test);
        end = System.nanoTime();
        System.out.println("Deque Strategy:     " + (end - start) + " ns");

        start = System.nanoTime();
        isPalindromeLinkedList(test);
        end = System.nanoTime();
        System.out.println("Linked List Strategy: " + (end - start) + " ns");

        String clean = test.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        start = System.nanoTime();
        isPalindromeRecursive(clean, 0, clean.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive Strategy:   " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        runUC7();
        runUC8();
        runUC9();
        runUC10();
        runUC11();
        runUC12();
        runUC13();
    }
}
