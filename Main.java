import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Activity Management System =====");
            System.out.println("1. Check available seats");
            System.out.println("2. Register student (with ID)");
            System.out.println("3. Delete student");
            System.out.println("4. Find student (with ID)");
            System.out.println("5. Store student details into a file");
            System.out.println("6. Load student details from the file");
            System.out.println("7. View list of students by name (sorted)");
            System.out.println("8. More Options (add name & marks)");
            System.out.println("c. Generate summary report");
            System.out.println("d. Generate full report");
            System.out.println("x. Exit");

            System.out.print("Enter your option: ");
            System.out.flush(); 
            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "1" -> manager.checkAvailableSeats();
                case "2" -> manager.registerStudent();
                case "3" -> manager.deleteStudent();
                case "4" -> manager.findStudent();
                case "5" -> FileHandler.saveToFile(manager.getStudents(), manager.getStudentCount());
                case "6" -> FileHandler.loadFromFile(manager);
                case "7" -> manager.sortStudentsByName();
                case "8" -> showSubMenu(manager, scanner);
                case "c" -> manager.generateSummaryReport();
                case "d" -> manager.generateFullReport();
                case "x" -> {
                    System.out.println("Exiting the program...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void showSubMenu(StudentManager manager, Scanner scanner) {
        while (true) {
            System.out.println("\n--- More Options ---");
            System.out.println("a. Add student name");
            System.out.println("b. Add module marks");
            System.out.println("x. Back to main menu");
            
            System.out.print("Enter your option: ");
            System.out.flush();
            String subOption = scanner.nextLine().trim().toLowerCase();

            switch (subOption) {
                case "a" -> manager.addStudentName();
                case "b" -> manager.addModuleMarks();
                case "x" -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}