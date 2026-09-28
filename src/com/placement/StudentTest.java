package com.placement;

public class StudentTest {

    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Sunitha",
                "sunitha@gmail.com",
                "9876543210",
                "CSE",
                8.5
        );

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("CGPA: " + student.getCgpa());
    }
}