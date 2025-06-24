public class Student {
    private final String studentId;
    private String studentName;
    private final int[] moduleMarks = new int[3];
    private final String[] moduleGrades = new String[3];

    public Student(String studentId) {
        this.studentId = studentId;
        this.studentName = "";

        for (int i = 0; i < 3; i++) {
            moduleGrades[i] = "";
        }
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public void setModuleMarks(int mark1, int mark2, int mark3) {
        this.moduleMarks[0] = mark1;
        this.moduleMarks[1] = mark2;
        this.moduleMarks[2] = mark3;
        calculateGrades();
    }

    private void calculateGrades() {
        for (int i = 0; i < 3; i++) {
            int mark = moduleMarks[i];
            if (mark >= 80) {
                moduleGrades[i] = "Distinction";
            } else if (mark >= 70) {
                moduleGrades[i] = "Merit";
            } else if (mark >= 40) {
                moduleGrades[i] = "Pass";
            } else {
                moduleGrades[i] = "Fail";
            }
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int[] getModuleMarks() {
        return moduleMarks;
    }

    public String[] getModuleGrades() {
        return moduleGrades;
    }

    public int getTotal() {
        return moduleMarks[0] + moduleMarks[1] + moduleMarks[2];
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public String getOverallGrade() {
        double avg = getAverage();
        if (avg >= 80) return "Distinction";
        else if (avg >= 70) return "Merit";
        else if (avg >= 40) return "Pass";
        else return "Fail";
    }

    @Override
    public String toString() {
        return studentId + " | " + studentName + " | " +
               moduleMarks[0] + " (" + moduleGrades[0] + "), " +
               moduleMarks[1] + " (" + moduleGrades[1] + "), " +
               moduleMarks[2] + " (" + moduleGrades[2] + ") | " +
               "Total: " + getTotal() + " | Avg: " + String.format("%.2f", getAverage()) +
               " | Overall Grade: " + getOverallGrade();
    }

    public String toFileString() {
        return studentId + "," + studentName + "," +
               moduleMarks[0] + "," + moduleMarks[1] + "," + moduleMarks[2];
    }

    public static Student fromFileString(String data) {
        String[] parts = data.split(",");
        if (parts.length != 5) return null;
        Student s = new Student(parts[0]);
        s.setStudentName(parts[1]);
        s.setModuleMarks(
            Integer.parseInt(parts[2]),
            Integer.parseInt(parts[3]),
            Integer.parseInt(parts[4])
        );
        return s;
    }
}