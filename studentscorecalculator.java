/* 
*** PROBLEM STATEMENT ***
Input: Takes marks obtained in each sbject (ou of 100).
Calculate the total marks: Sum up all the marks entered for every subject;
Calculate the avg pecentage : divide the sum of the marks entered by the total actual marks * 100 - to get the avg percentage 
Grade Calculation : Assign the grades according to the marks obtained 
Display Result: display marks obtained, avg pecentage and the grade obtained by the student
*/


import java.util.Scanner;

public class studentscorecalculator {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the total number of subjects: ");
        int subjectNum = scan.nextInt();
        int totalObtainedMarks = 0;
        
        for (int i = 1; i <= subjectNum; i++){
            System.out.println("Enter the marks of subject " + i + " (out of 100):");
            int marks = scan.nextInt();
            totalObtainedMarks += marks;
        }

        double percentage = (totalObtainedMarks * 100.0) / (subjectNum * 100);

        int gradeCategory = (int) percentage / 10;
        String grade;
        
        switch (gradeCategory){
            case 10: 
            case 9: 
                grade = "A";
                break;
            case 8: 
                grade = "B";
                break;
            case 7: 
                grade = "C";
                break;
            case 6: 
                grade = "D";
                break;
            default:
                grade = "F (Fail)";
                break;
        }
        
        // --- FANCY DESIGN LOGIC ---
        String title = "RESULT CARD";
        int boxWidth = 46; // Outer width boundaries
        int paddingSize = (boxWidth - 2 - title.length()) / 2; 

        System.out.println("\n╔════════════════════════════════════════════╗");
        
        // Centered header printing logic
        System.out.print("║");
        System.out.print(" ".repeat(paddingSize) + title + " ".repeat(paddingSize));
        System.out.println("║");
        
        System.out.println("╠════════════════════════════════════════════╣");
        
        // Left-aligned body metrics using formatting specifiers
        System.out.printf("║ Total Marks: %-29s ║\n", totalObtainedMarks + " / " + (subjectNum * 100));
        System.out.printf("║ Percentage:  %-29.2f%% ║\n", percentage);
        System.out.printf("║ Grade:       %-29s ║\n", grade);
        
        System.out.println("╚════════════════════════════════════════════╝");

        scan.close();
    }
}