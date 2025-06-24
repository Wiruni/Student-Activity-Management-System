# Student-Activity-Management-System
This is a Java-based console application designed to manage student academic results for three modules in Semester 1. The system is targeted for university staff to register students, manage their module results, and generate reports summarizing student performance.

## Features

- **Capacity:** Supports registration and management of up to 100 students.
- **Student Details:**
  - Student ID (8 characters, e.g., w1234567)
  - Student Name
  - Marks for 3 modules
  - Grades for each module (Distinction, Merit, Pass, Fail)
  - Overall grade based on average marks
- **Menu-driven Interface** with options to:
  1. Check available seats
  2. Register a student by ID
  3. Delete a student by ID
  4. Find and display a student’s details by ID
  5. Save student details to a file (`students.txt`)
  6. Load student details from the file
  7. View a list of students sorted by their names (custom bubble sort)
  8. Additional controls to add student name and module marks
  - **Generate reports:**
    - Summary of total registrations and pass counts per module
    - Complete detailed report sorted by average marks (highest to lowest)



## Technologies Used

- Java 17 (or later) for modern syntax and features like enhanced switch statements
- File I/O for persistence of student data
- Console input and output for user interaction



## Project Structure

| File Name         | Description                                  |
|-------------------|----------------------------------------------|
| `Student.java`    | Defines the Student class with ID, name, marks, and grades per module |
| `StudentManager.java` | Manages an array of students and all CRUD operations |
| `FileHandler.java` | Handles saving/loading student data to/from a text file |
| `Main.java`       | Entry point; displays menus and handles user interaction |



## How to Run

1. **Compile the project:**

   ```bash
   javac *.java
   
2. **Run the program:**

java Main

3. Follow the on-screen menu options to interact with the system.

**Usage Notes**
Student grades per module are automatically calculated based on the marks entered.

The system saves and loads data from students.txt in the same directory.

When entering marks, valid integer inputs (0-100) are expected.

The system uses a bubble sort implementation for sorting students by name and average marks.

Input is case-insensitive for menu options.
