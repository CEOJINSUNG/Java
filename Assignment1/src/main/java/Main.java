import java.util.Scanner;

// This file is for Task1
public class Main {

    public static void main(String[] args) {

        // ======================= Task 1 Start =======================
        // Create Student Object
        Student student = new Student();

        // Using Scanner User can enter the content
        // Create Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Request name
        System.out.print("Enter your name: ");

        // Upon receiving the name, the object field is entered as a setter function.
        student.setName(scanner.next());

        // Request date of birth
        System.out.print("Enter your date of birth: ");

        // Upon receiving the date of birth, the object field is entered as a setter function.
        // The type of date is Integer, so it has to be entered by nextInt().
        student.setBirthDate(scanner.nextInt());

        // Request cumulative GPA
        System.out.print("Enter your cumulative GPA: ");

        // Upon receiving the cumulative GPA, the object field is entered as a setter function.
        // The type of date is Float, so it has to be entered by nextInt().
        student.setGpa(scanner.nextFloat());

        // Request department
        System.out.print("Enter your department: ");

        // Upon receiving the department, the object field is entered as a setter function.
        student.setDepartment(scanner.next());

        // After Getting Info from User and Print the Result
        System.out.println("=======================");
        System.out.println("Student name: "+ student.getName());
        System.out.println("Student's age: "+ student.getAge());
        System.out.println("Student's CGPA: "+ student.getGpa());
        System.out.println("Student's department: "+ student.getDepartment());

        // ======================= Task 1 End =======================
    }

}
