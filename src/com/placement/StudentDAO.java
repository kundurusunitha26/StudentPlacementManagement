package com.placement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // INSERT student
    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(name, email, phone, department, cgpa) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getDepartment());
            statement.setDouble(5, student.getCgpa());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // GET all students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int studentId =
                        resultSet.getInt("student_id");

                String name =
                        resultSet.getString("name");

                String email =
                        resultSet.getString("email");

                String phone =
                        resultSet.getString("phone");

                String department =
                        resultSet.getString("department");

                double cgpa =
                        resultSet.getDouble("cgpa");

                Student student = new Student(
                        studentId,
                        name,
                        email,
                        phone,
                        department,
                        cgpa
                );

                students.add(student);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }
 // UPDATE student
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, email = ?, " +
                     "phone = ?, department = ?, cgpa = ? " +
                     "WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getDepartment());
            statement.setDouble(5, student.getCgpa());
            statement.setInt(6, student.getStudentId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
 // DELETE student
    public void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, studentId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}