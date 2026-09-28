package com.placement;

import java.util.List;

public class PlacementViewTest {

    public static void main(String[] args) {

        PlacementDAO dao = new PlacementDAO();

        List<Placement> placements = dao.getAllPlacements();

        for (Placement p : placements) {

            System.out.println(
                p.getPlacementId() + " | " +
                p.getStudentId() + " | " +
                p.getCompanyId() + " | " +
                p.getPackageLPA() + " | " +
                p.getPlacementDate() + " | " +
                p.getStatus()
            );
        }
    }
}