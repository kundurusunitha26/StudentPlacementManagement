package com.placement;

public class Company {

    private int companyId;
    private String companyName;
    private String location;
    private double packageLpa;
    private String hrEmail;

    public Company(int companyId, String companyName,
                   String location, double packageLpa,
                   String hrEmail) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
        this.packageLpa = packageLpa;
        this.hrEmail = hrEmail;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public double getPackageLpa() {
        return packageLpa;
    }

    public String getHrEmail() {
        return hrEmail;
    }
}