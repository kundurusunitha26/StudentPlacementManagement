package com.placement;

public class StudentDeleteTest {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.deleteStudent(1);
    }
}