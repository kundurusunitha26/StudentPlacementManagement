package com.placement;

public class Placement {

    private int placementId;
    private int studentId;
    private int companyId;
    private String placementDate;
    private String status;
    private double packageLPA;

    public Placement() {
    }

    public Placement(int placementId, int studentId, int companyId,
    		         double packageLPA,
                     String placementDate, String status) {
        this.placementId = placementId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.packageLPA = packageLPA;
        this.placementDate = placementDate;
        this.status = status;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public double getPackageLPA() {
    	return packageLPA;
    }
    public void setPackageLPA(double packageLPA) {
    	this.packageLPA = packageLPA;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(String placementDate) {
        this.placementDate = placementDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}