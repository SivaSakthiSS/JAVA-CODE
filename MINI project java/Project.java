import java.util.*;

class Student {
    private final String college;
    private final String name;
    private final int rollno;
    private String dept;
    private final int age;

    public Student(String college, String name, int rollno, int age, String dept) {
        this.college = college;
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.dept = dept;
    }

    public int getRollno() {
        return rollno;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void display() {
        System.out.println("Name    : " + name);
        System.out.println("College : " + college);
        System.out.println("Dept    : " + dept);
        System.out.println("Roll No : " + rollno);
        System.out.println("Age     : " + age);
        System.out.println("----------------------");
    }
}

class StudentManager {
    private final ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student s) {
        list.add(s);
        System.out.println("Student added successfully");
    }

    public void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : list) {
            s.display();
        }
    }

    public void searchStudent(int rollno) {
        for (Student s : list) {
            if (s.getRollno() == rollno) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void updateStudent(int rollno, String dept) {
        for (Student s : list) {
            if (s.getRollno() == rollno) {
                s.setDept(dept);
                System.out.println("Student updated successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void deleteStudent(int rollno) {
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getRollno() == rollno) {
                it.remove();
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }
}

public class Project {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentManager sm = new StudentManager();

    while (true) {
        System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

    switch (choice) {
        case 1 -> {
            System.out.print("College: ");
            String college = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Dept: ");
            String dept = sc.nextLine();
            sm.addStudent(new Student(college, name, roll, age, dept));
        }
        case 2 -> sm.viewStudents();
        case 3 -> {
            System.out.print("Enter roll no: ");
            sm.searchStudent(sc.nextInt());
        }
        case 4 -> {
            System.out.print("Enter roll no: ");
            sm.deleteStudent(sc.nextInt());
        }
        case 5 -> {
            System.out.print("Enter roll no: ");
            int r = sc.nextInt();
            sc.nextLine();
            System.out.print("New Dept: ");
            String d = sc.nextLine();
            sm.updateStudent(r, d);
        }
        case 6 -> {
            System.out.println("Thank you!");
            sc.close();
            System.exit(0);
        }
        default -> System.out.println("Invalid choice");
    }
        }
    }
}
