package com.placement;

public class CompanyUpdateTest {

    public static void main(String[] args) {

        CompanyDAO dao = new CompanyDAO();

        Company company = new Company(
                1,
                "TCS",
                "Hyderabad",
                6.5,
                "hr@tcs.com"
        );

        dao.updateCompany(company);
    }
}