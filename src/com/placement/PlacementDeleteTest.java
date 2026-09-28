package com.placement;

public class PlacementDeleteTest {

    public static void main(String[] args) {

        PlacementDAO dao = new PlacementDAO();

        dao.deletePlacement(2);
    }
}