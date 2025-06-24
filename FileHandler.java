import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(Student[] students, int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                if (students[i] != null) {
                    writer.write(students[i].toFileString());
                    writer.newLine();
                }
            }
            System.out.println("Student data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void loadFromFile(StudentManager manager) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved file found.");
            return;
        }

        List<Student> studentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFileString(line);
                if (student != null) {
                    studentList.add(student);
                }
            }

            Student[] loadedStudents = new Student[100];
            for (int i = 0; i < studentList.size(); i++) {
                loadedStudents[i] = studentList.get(i);
            }

            manager.setStudents(loadedStudents, studentList.size());
            System.out.println("Student data loaded from file.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}