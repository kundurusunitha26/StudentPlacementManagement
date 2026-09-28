package com.placement;
import java.util.List;


public class CompanyViewTest {

    public static void main(String[] args) {

        CompanyDAO companyDAO = new CompanyDAO();

        List<Company> companies =
                companyDAO.getAllCompanies();

        for (Company company : companies) {

            System.out.println(
                    company.getCompanyId() + " | " +
                    company.getCompanyName() + " | " +
                    company.getLocation() + " | " +
                    company.getPackageLpa() + " LPA | " +
                    company.getHrEmail()
            );
        }
    }
    
}