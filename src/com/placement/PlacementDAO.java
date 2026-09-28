
package com.placement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlacementDAO {

    // Add Placement
    public void addPlacement(Placement placement) {

        String sql = "INSERT INTO placements " +
                "(student_id, company_id, package, placement_date, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, placement.getStudentId());
            ps.setInt(2, placement.getCompanyId());
            ps.setDouble(3, placement.getPackageLPA());
            ps.setString(4, placement.getPlacementDate());
            ps.setString(5, placement.getStatus());

            ps.executeUpdate();

            System.out.println("Placement added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all Placements
    public List<Placement> getAllPlacements() {

        List<Placement> list = new ArrayList<>();

        String sql = "SELECT placement_id, student_id, company_id, " +
                "`package`, placement_date, status FROM placements";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Placement placement = new Placement(
                        rs.getInt("placement_id"),
                        rs.getInt("student_id"),
                        rs.getInt("company_id"),
                        rs.getDouble("package"),
                        rs.getString("placement_date"),
                        rs.getString("status")
                );

                list.add(placement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update Placement
    public void updatePlacement(
            int placementId,
            int studentId,
            int companyId,
            double packageLPA,
            String placementDate,
            String status) {

        String sql = "UPDATE placements SET " +
                "student_id=?, " +
                "company_id=?, " +
                "`package`=?, " +
                "placement_date=?, " +
                "status=? " +
                "WHERE placement_id=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, companyId);
            ps.setDouble(3, packageLPA);
            ps.setString(4, placementDate);
            ps.setString(5, status);
            ps.setInt(6, placementId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Rows updated: " + rows);
                System.out.println("Placement updated successfully!");
            } else {
                System.out.println("Placement ID not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Placement
    public void deletePlacement(int placementId) {

        String sql = "DELETE FROM placements WHERE placement_id=?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, placementId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Placement deleted successfully!");
            } else {
                System.out.println("Placement ID not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Placement Report using JOIN
    public void getPlacementReport() {

        String sql = "SELECT " +
                "s.name AS student_name, " +
                "c.company_name, " +
                "p.`package` AS package_lpa, " +
                "p.placement_date, " +
                "p.status " +
                "FROM placements p " +
                "JOIN students s ON p.student_id = s.student_id " +
                "JOIN companies c ON p.company_id = c.company_id";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Placement Report =====");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        rs.getString("student_name") + " | " +
                        rs.getString("company_name") + " | " +
                        rs.getDouble("package_lpa") + " LPA | " +
                        rs.getString("placement_date") + " | " +
                        rs.getString("status")
                );
            }

            if (!found) {
                System.out.println("No placement records found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
