public class Student {
    private static int counter = 1;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(String name, int age, String gender, String department, double gpa) {
        this.id = counter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }
    public void resetCounter(){
        counter = 1;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public String getLine() {
        return id + "," + name + "," + age + "," + gender + "," + department + "," + gpa;
    }
}
