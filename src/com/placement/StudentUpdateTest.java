package com.placement;

public class StudentUpdateTest {

    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Sunitha",
                "sunitha@gmail.com",
                "9876543210",
                "CSE",
                9.0
        );

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.updateStudent(student);
    }
}