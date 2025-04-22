//StudentDAO.java

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    // Add a new student to the DB
    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getPRN());
            ps.setString(3, student.getBranch());
            ps.setString(4, student.getBatch());
            ps.setFloat(5, student.getCGPA());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Fetch all students
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getString("name"),
                    rs.getInt("prn"),
                    rs.getString("branch"),
                    rs.getString("batch"),
                    rs.getFloat("cgpa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        return list;
    }

    // Search by PRN
    public Student searchByPRN(int prn) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE prn = ?")) {
            ps.setInt(1, prn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getString("name"), prn, rs.getString("branch"), rs.getString("batch"), rs.getFloat("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by PRN: " + e.getMessage());
        }
        return null;
    }

    // Update student
    public boolean updateStudent(Student student) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, branch=?, batch=?, cgpa=? WHERE prn=?")) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getBranch());
            ps.setString(3, student.getBatch());
            ps.setFloat(4, student.getCGPA());
            ps.setInt(5, student.getPRN());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
        return false;
    }

    // Delete student
    public boolean deleteStudent(int prn) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE prn = ?")) {
            ps.setInt(1, prn);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
        return false;
    }
}
