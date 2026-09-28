package com.placement;

public class CompanyAddTest {

    public static void main(String[] args) {

        Company company = new Company(
                0,
                "Infosys",
                "Hyderabad",
                6.5,
                "hr@infosys.com"
        );

        CompanyDAO companyDAO = new CompanyDAO();

        companyDAO.addCompany(company);
    }
}