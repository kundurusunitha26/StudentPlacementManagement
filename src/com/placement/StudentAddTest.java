package com.placement;

public class StudentAddTest {

    public static void main(String[] args) {

        Student student = new Student(
                0,
                "Sunitha",
                "sunitha12@gmail.com",
                "9876543210",
                "CSE",
                8.5
        );

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.addStudent(student);
    }
}