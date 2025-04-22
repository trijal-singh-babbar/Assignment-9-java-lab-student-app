//Main.java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();
        int choice;

        do {
            System.out.println("\nMenu:\n1. Add Student\n2. Display Students\n3. Search by PRN\n4. Update Student\n5. Delete Student\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter PRN: ");
                    int prn = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = scan.nextLine();
                    System.out.print("Enter Batch: ");
                    String batch = scan.nextLine();
                    System.out.print("Enter CGPA: ");
                    float cgpa = scan.nextFloat();
                    operations.addStudent(new Student(name, prn, branch, batch, cgpa));
                }
                case 2 -> operations.displayStudents();
                case 3 -> {
                    System.out.print("Enter PRN: ");
                    int prn = scan.nextInt();
                    Student s = operations.searchByPRN(prn);
                    if (s != null) s.display();
                    else System.out.println("Student not found.");
                }
                case 4 -> {
                    System.out.print("Enter PRN of student to update: ");
                    int prn = scan.nextInt(); scan.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter New Branch: ");
                    String branch = scan.nextLine();
                    System.out.print("Enter New Batch: ");
                    String batch = scan.nextLine();
                    System.out.print("Enter New CGPA: ");
                    float cgpa = scan.nextFloat();
                    boolean updated = operations.updateStudent(new Student(name, prn, branch, batch, cgpa));
                    System.out.println(updated ? "Updated successfully." : "Student not found.");
                }
                case 5 -> {
                    System.out.print("Enter PRN to delete: ");
                    int prn = scan.nextInt();
                    System.out.println(operations.deleteStudent(prn) ? "Deleted successfully." : "Student not found.");
                }
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }
}
