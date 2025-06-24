import java.util.Scanner;

public class StudentManager {
    private Student[] students = new Student[100];
    private int studentCount = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void checkAvailableSeats() {
        System.out.println("Available seats: " + (100 - studentCount));
    }

    public void registerStudent() {
        if (studentCount >= 100) {
            System.out.println("Intake is full.");
            return;
        }

        System.out.print("Enter Student ID (e.g., w1234567): ");
        String id = scanner.nextLine();

        if (findStudentIndex(id) != -1) {
            System.out.println("Student already registered.");
            return;
        }

        students[studentCount++] = new Student(id);
        System.out.println("Student registered successfully.");
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        for (int i = index; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[--studentCount] = null;

        System.out.println("Student deleted.");
    }

    public void findStudent() {
        System.out.print("Enter Student ID to find: ");
        String id = scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student found:");
        System.out.println(students[index]);
    }

    public void sortStudentsByName() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getStudentName().compareToIgnoreCase(students[j + 1].getStudentName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Students sorted by name:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    public void addStudentName() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students[index].setStudentName(name);

        System.out.println("Name updated.");
    }

    public void addModuleMarks() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Module 1 Marks: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter Module 2 Marks: ");
        int m2 = scanner.nextInt();
        System.out.print("Enter Module 3 Marks: ");
        int m3 = scanner.nextInt();
        scanner.nextLine(); 

        students[index].setModuleMarks(m1, m2, m3);

        System.out.println("Marks updated.");
    }

    public void generateSummaryReport() {
        int module1Pass = 0, module2Pass = 0, module3Pass = 0;

        for (int i = 0; i < studentCount; i++) {
            int[] marks = students[i].getModuleMarks();
            if (marks[0] >= 40) module1Pass++;
            if (marks[1] >= 40) module2Pass++;
            if (marks[2] >= 40) module3Pass++;
        }

        System.out.println("Total students: " + studentCount);
        System.out.println("Students passed Module 1: " + module1Pass);
        System.out.println("Students passed Module 2: " + module2Pass);
        System.out.println("Students passed Module 3: " + module3Pass);
    }

    public void generateFullReport() {

        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (students[j].getAverage() < students[j + 1].getAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("Student Report (Sorted by Average):");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    private int findStudentIndex(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudents(Student[] loadedStudents, int count) {
        this.students = loadedStudents;
        this.studentCount = count;
    }
}