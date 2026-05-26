import java.util.Scanner;
public class palindromeChecker {
    public static void main (String args[]) {
        Scanner reader = new Scanner (System.in);
        System.out.println("Enter a string to check if it's a palindrome: ");
        String input = reader.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        reader.close();

    }
}