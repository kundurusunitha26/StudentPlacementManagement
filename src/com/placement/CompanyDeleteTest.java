package com.placement;

public class CompanyDeleteTest {

    public static void main(String[] args) {

        CompanyDAO dao = new CompanyDAO();

        dao.deleteCompany(3);
    }
}