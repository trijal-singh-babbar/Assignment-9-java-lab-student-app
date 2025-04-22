//StudentOperations.java

import java.util.*;

public class StudentOperations {
    private StudentDAO dao;

    public StudentOperations() {
        dao = new StudentDAO();
    }

    public void addStudent(Student student) {
        dao.addStudent(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        ArrayList<Student> list = dao.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : list) s.display();
        }
    }

    public Student searchByPRN(int prn) {
        return dao.searchByPRN(prn);
    }

    public boolean updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    public boolean deleteStudent(int prn) {
        return dao.deleteStudent(prn);
    }
}
