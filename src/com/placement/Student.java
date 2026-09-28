package com.placement;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private double cgpa;

    public Student(int studentId, String name, String email,
                   String phone, String department, double cgpa) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }
}