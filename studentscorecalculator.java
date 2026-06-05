import java.util.Scanner;

public class ScoreCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        // Array to store marks of each subject
        double[] marks = new double[numSubjects];
        double totalScore = 0;

        // Input validation loop
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                double inputMarks = sc.nextDouble();

                // Ensure input marks are valid real-world numbers
                if (inputMarks >= 0 && inputMarks <= 100) {
                    marks[i] = inputMarks;
                    totalScore += inputMarks;
                    break; // Valid input, break the inner validation loop
                } else {
                    System.out.println(" Invalid input! Marks must be between 0 and 100.");
                }
            }
        }

        // Calculate Average Percentage
        double averagePercentage = totalScore / numSubjects;

        // Determine Grade based on tier structure
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // --- Output Performance Report ---
        System.out.println("\n==================================");
        System.out.println("        STUDENT REPORT CARD       ");
        System.out.println("==================================");
        System.out.printf("Total Marks Scored : %.2f / %d\n", totalScore, (numSubjects * 100));
        System.out.printf("Average Percentage : %.2f%%\n", averagePercentage);
        System.out.println("Final Grade        : " + grade);
        System.out.println("==================================");

        sc.close();
    }
}