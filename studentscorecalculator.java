import java.util.Scanner; 

public class studentScoreCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Get number of subjects with validation
        System.out.println("Enter the total number of subjects: ");
        int subjectNum = scan.nextInt();
        
        if (subjectNum <= 0) {
            System.out.println("Error: Subject count must be greater than 0.");
            scan.close();
            return;
        }
        
        int totalObtainedMarks = 0;
        
        // Get marks for each subject with validation
        for (int i = 1; i <= subjectNum; i++) {
            System.out.println("Enter the marks of subject " + i + " (out of 100):");
            int marks = scan.nextInt();
            
            // Validate marks are between 0 and 100
            if (marks < 0 || marks > 100) {
                System.out.println("Error: Marks must be between 0 and 100. Skipping this subject.");
                i--; // Repeat this iteration
                continue;
            }
            
            totalObtainedMarks += marks;
        }
        
        // Calculate percentage
        double percentage = (totalObtainedMarks * 100.0) / (subjectNum * 100);
        
        // Determine grade using switch statement
        int gradeCategory = (int) percentage / 10;
        String grade;
        
        switch (gradeCategory) {
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
        
        // Display result card with formatting
        String title = "RESULT CARD";
        int boxWidth = 46;
        int paddingSize = (boxWidth - 2 - title.length()) / 2;
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        
        System.out.print("║");
        System.out.print(" ".repeat(paddingSize) + title + " ".repeat(paddingSize));
        System.out.println("║");
        
        System.out.println("╠════════════════════════════════════════════╣");
        
        System.out.printf("║ Total Marks: %-29s ║\n", totalObtainedMarks + " / " + (subjectNum * 100));
        System.out.printf("║ Percentage:  %-29.2f%% ║\n", percentage);
        System.out.printf("║ Grade:       %-29s ║\n", grade);
        
        System.out.println("╚════════════════════════════════════════════╝");
        
        scan.close();
    }
}