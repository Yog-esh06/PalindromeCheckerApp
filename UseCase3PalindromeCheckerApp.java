public class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        String original = "madam";
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        if (original.equals(reversed)) {
            System.out.println("The given string \"" + original + "\" is a PALINDROME.");
        } else {
            System.out.println("The given string \"" + original + "\" is NOT a palindrome.");
        }
    }
}
