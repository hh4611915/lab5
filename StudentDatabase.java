import java.io.*;
import java.util.ArrayList;

public class StudentDatabase {
    private ArrayList<Student> students;
    private String filename;

    public StudentDatabase(String filename) {
        this.filename = filename;
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String gender, String department, double gpa) {
        Student s = new Student(name, age, gender, department, gpa);
        students.add(s);
        System.out.println("Added: " + s.getLine());
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nAll Students:");
            for (Student s : students) {
                System.out.println(s.getLine());
            }
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.getLine());
                bw.newLine();
            }
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String gender = parts[3];
                    String department = parts[4];
                    double gpa = Double.parseDouble(parts[5]);
                    students.add(new Student(name, age, gender, department, gpa));
                }
            }
            System.out.println("Students loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No existing file found. A new one will be created.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


