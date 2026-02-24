public class UseCase2PalindromeCheckerApp {

    private static final String APP_VERSION = "1.1.0";

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("     PALINDROME CHECKER APP");
        System.out.println("====================================");

        System.out.println("Application Version : " + APP_VERSION);
        System.out.println("====================================");

        
        String word = "madam";

        System.out.println("Checking word: " + word);

        
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + word.charAt(i);
        }
        
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
