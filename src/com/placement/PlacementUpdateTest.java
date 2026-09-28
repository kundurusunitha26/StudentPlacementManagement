package com.placement;

public class PlacementUpdateTest {

    public static void main(String[] args) {

        PlacementDAO dao = new PlacementDAO();

        System.out.println("UPDATE TEST STARTED");

        dao.updatePlacement(
            3,
            3,
            1,
            8.5,
            "2026-09-28",
            "Placed"
        );
    }
}