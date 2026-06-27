import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        try {
            System.out.println("Enter a string to check if it's a palindrome: ");
            String input = reader.nextLine().trim();
            
            if (input.isEmpty()) {
                System.out.println("Error: Please enter a non-empty string.");
                return;
            }
            
            if (isPalindrome(input)) {
                System.out.println("✓ The string is a palindrome.");
            } else {
                System.out.println("✗ The string is not a palindrome.");
            }
        } finally {
            reader.close();
        }
    }
    
    /**
     * Checks if a string is a palindrome, ignoring spaces, punctuation, and case.
     * 
     * @param input the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    private static boolean isPalindrome(String input) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if empty after cleaning
        if (cleaned.isEmpty()) {
            return false;
        }
        
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}