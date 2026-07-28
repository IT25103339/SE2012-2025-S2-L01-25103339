import java.util.Scanner;

public class MarksNew {
    
    // Helper method for grades
    public static String getGrade(int mark) {
        if (mark >= 90) return "Grade A";
        else if (mark >= 80) return "Grade B";
        else if (mark >= 70) return "Grade C";
        else if (mark >= 60) return "Grade D";
        else return "Fail";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());
        
        int[][] marks = new int[n][3];
        boolean run = true;
        
        while (run) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Subject average");
            System.out.println("4. Student average");
            System.out.println("5. Student total");
            System.out.println("6. Display grades");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(sc.nextLine());
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID (1 to " + n + "): ");
                    int stdIdAdd = Integer.parseInt(sc.nextLine());
                    if (stdIdAdd >= 1 && stdIdAdd <= n) {
                        System.out.print("Mathematics: ");
                        marks[stdIdAdd - 1][0] = Integer.parseInt(sc.nextLine());
                        System.out.print("Chemistry: ");
                        marks[stdIdAdd - 1][1] = Integer.parseInt(sc.nextLine());
                        System.out.print("Physics: ");
                        marks[stdIdAdd - 1][2] = Integer.parseInt(sc.nextLine());
                        System.out.println("Marks added successfully.");
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter Student ID: ");
                    int stdIdUp = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Subject ID (1-Math, 2-Chem, 3-Phy): ");
                    int subIdUp = Integer.parseInt(sc.nextLine());
                    
                    if ((stdIdUp >= 1 && stdIdUp <= n) && (subIdUp >= 1 && subIdUp <= 3)) {
                        System.out.print("Enter the new mark: ");
                        marks[stdIdUp - 1][subIdUp - 1] = Integer.parseInt(sc.nextLine());
                        System.out.println("Mark updated successfully.");
                    } else {
                        System.out.println("Invalid Student ID/Subject ID.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Subject ID (1-Math, 2-Chem, 3-Phy): ");
                    int subIdAvg = Integer.parseInt(sc.nextLine());
                    if (subIdAvg >= 1 && subIdAvg <= 3) {
                        int totalSub = 0;
                        for (int i = 0; i < n; i++) {
                            totalSub += marks[i][subIdAvg - 1];
                        }
                        double avgSub = totalSub / (double) n;
                        System.out.printf("Subject average = %.2f\n", avgSub);
                    } else {
                        System.out.println("Invalid Subject ID.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Student ID: ");
                    int stdIdAvg = Integer.parseInt(sc.nextLine());
                    if (stdIdAvg >= 1 && stdIdAvg <= n) {
                        int totalStd = 0;
                        for (int i = 0; i < 3; i++) {
                            totalStd += marks[stdIdAvg - 1][i];
                        }
                        double avgStd = totalStd / 3.0;
                        System.out.printf("Student average = %.2f\n", avgStd);
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter Student ID: ");
                    int stdIdTot = Integer.parseInt(sc.nextLine());
                    if (stdIdTot >= 1 && stdIdTot <= n) {
                        int totalStdMark = 0;
                        for (int i = 0; i < 3; i++) {
                            totalStdMark += marks[stdIdTot - 1][i];
                        }
                        System.out.println("Total marks = " + totalStdMark);
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;
                    
                case 6:
                    // Option 6 newly added for displaying grades tabularly
                    System.out.println("\nGrades:");
                    System.out.printf("%-10s %-12s %-12s %-12s%n", "Student", "Math", "Chemistry", "Physics");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%-10d %-12s %-12s %-12s%n", 
                            i + 1, 
                            getGrade(marks[i][0]), 
                            getGrade(marks[i][1]), 
                            getGrade(marks[i][2]));
                    }
                    break;
                    
                case 7:
                    run = false;
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        }
        sc.close();
    }
}