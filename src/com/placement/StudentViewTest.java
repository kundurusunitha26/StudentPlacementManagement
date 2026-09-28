package com.placement;

import java.util.List;

public class StudentViewTest {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        List<Student> students = studentDAO.getAllStudents();

        for (Student student : students) {

            System.out.println(
                    student.getStudentId() + " | " +
                    student.getName() + " | " +
                    student.getEmail() + " | " +
                    student.getPhone() + " | " +
                    student.getDepartment() + " | " +
                    student.getCgpa()
            );
        }
    }
}