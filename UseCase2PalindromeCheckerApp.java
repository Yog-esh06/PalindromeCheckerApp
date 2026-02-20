public class UseCase2PalindromeCheckerApp {

    // Application Version
    private static final String APP_VERSION = "1.1.0";

    // Main Method - Entry Point
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("     PALINDROME CHECKER APP");
        System.out.println("====================================");

        System.out.println("Application Version : " + APP_VERSION);
        System.out.println("====================================");

        // Hardcoded String Literal
        String word = "madam";

        System.out.println("Checking word: " + word);

        // Reverse the string manually
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + word.charAt(i);
        }

        // Conditional Statement
        if (word.equals(reversedWord)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        System.out.println("====================================");
        System.out.println("Program execution completed.");
        System.out.println("====================================");
    }
}