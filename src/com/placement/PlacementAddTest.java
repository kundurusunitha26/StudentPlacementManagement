package com.placement;

public class PlacementAddTest {

    public static void main(String[] args) {

    	
        PlacementDAO dao = new PlacementDAO();
        Placement placement = new Placement(
        	    1,
        	    3,
        	    1,
        	    6.5,
        	    "2026-09-27",
        	    "Placed"
        	);

        dao.addPlacement(placement);
    }
}