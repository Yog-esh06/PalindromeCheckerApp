public class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        
        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        
        while (start < end) {

            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input String : " + input);

        if (isPalindrome) {
            System.out.println("Result : It is a Palindrome");
        } else {
            System.out.println("Result : It is NOT a Palindrome");
        }
    }
}
