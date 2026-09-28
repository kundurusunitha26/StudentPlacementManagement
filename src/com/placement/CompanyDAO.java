package com.placement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CompanyDAO {

    // ADD company
    public void addCompany(Company company) {

        String sql = "INSERT INTO companies " +
                     "(company_name, location, package_lpa, hr_email) " +
                     "VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, company.getCompanyName());
            statement.setString(2, company.getLocation());
            statement.setDouble(3, company.getPackageLpa());
            statement.setString(4, company.getHrEmail());

            statement.executeUpdate();

            System.out.println("Company added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public List<Company> getAllCompanies() {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT * FROM companies";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int companyId = resultSet.getInt("company_id");
                String companyName = resultSet.getString("company_name");
                String location = resultSet.getString("location");
                double packageLpa = resultSet.getDouble("package_lpa");
                String hrEmail = resultSet.getString("hr_email");

                Company company = new Company(
                        companyId,
                        companyName,
                        location,
                        packageLpa,
                        hrEmail
                );

                companies.add(company);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return companies;
    }
 // UPDATE company
 // UPDATE company
    public void updateCompany(Company company) {

        String sql = "UPDATE companies SET company_name=?, " +
                     "location=?, package_lpa=?, hr_email=? " +
                     "WHERE company_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getLocation());
            ps.setDouble(3, company.getPackageLpa());
            ps.setString(4, company.getHrEmail());
            ps.setInt(5, company.getCompanyId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Company updated successfully!");
            } else {
                System.out.println("Company not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE company
    public void deleteCompany(int id) {

        String sql = "DELETE FROM companies WHERE company_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Company deleted successfully!");
            } else {
                System.out.println("Company not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}