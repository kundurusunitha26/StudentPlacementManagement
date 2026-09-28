
package com.placement;

import java.util.List;
import java.util.Scanner;

public class PlacementManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        PlacementDAO placementDAO = new PlacementDAO();

        while (true) {

            System.out.println("\n===== Student Placement Management =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Company");
            System.out.println("4. View Companies");
            System.out.println("5. Add Placement");
            System.out.println("6. View Placements");
            System.out.println("7. Update Placement");
            System.out.println("8. Delete Placement");
            System.out.println("9. Update Student");
            System.out.println("10. Delete Student");
            System.out.println("11. Update Company");
            System.out.println("12. Delete Company");
            System.out.println("13. Placement Report");
            System.out.println("14. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            // ================= ADD STUDENT =================
            case 1:
                sc.nextLine();

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty!");
                    break;
                }

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                if (!email.contains("@") || !email.contains(".")) {
                    System.out.println("Invalid email!");
                    break;
                }

                System.out.print("Enter phone: ");
                String phone = sc.nextLine();

                if (!phone.matches("\\d{10}")) {
                    System.out.println(
                            "Phone number must contain 10 digits!");
                    break;
                }

                System.out.print("Enter department: ");
                String department = sc.nextLine();

                if (department.trim().isEmpty()) {
                    System.out.println(
                            "Department cannot be empty!");
                    break;
                }

                System.out.print("Enter CGPA: ");
                double cgpa = sc.nextDouble();

                if (cgpa < 0 || cgpa > 10) {
                    System.out.println(
                            "Invalid CGPA! CGPA must be between 0 and 10.");
                    break;
                }

                Student student = new Student(
                        0,
                        name,
                        email,
                        phone,
                        department,
                        cgpa
                );

                studentDAO.addStudent(student);
                break;

            // ================= VIEW STUDENTS =================
            case 2:

                List<Student> students =
                        studentDAO.getAllStudents();

                System.out.println("\n===== Student List =====");

                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {

                    for (Student s : students) {

                        System.out.println(
                                s.getStudentId() + " | " +
                                s.getName() + " | " +
                                s.getEmail() + " | " +
                                s.getPhone() + " | " +
                                s.getDepartment() + " | " +
                                s.getCgpa()
                        );
                    }
                }

                break;

            // ================= ADD COMPANY =================
            case 3:
                sc.nextLine();

                System.out.print("Enter company name: ");
                String companyName = sc.nextLine();

                if (companyName.trim().isEmpty()) {
                    System.out.println(
                            "Company name cannot be empty!");
                    break;
                }

                System.out.print("Enter location: ");
                String location = sc.nextLine();

                if (location.trim().isEmpty()) {
                    System.out.println(
                            "Location cannot be empty!");
                    break;
                }

                System.out.print("Enter package (LPA): ");
                double packageLpa = sc.nextDouble();

                if (packageLpa <= 0) {
                    System.out.println(
                            "Package must be greater than 0!");
                    break;
                }

                sc.nextLine();

                System.out.print("Enter HR email: ");
                String hrEmail = sc.nextLine();

                if (!hrEmail.contains("@")
                        || !hrEmail.contains(".")) {

                    System.out.println("Invalid HR email!");
                    break;
                }

                Company company = new Company(
                        0,
                        companyName,
                        location,
                        packageLpa,
                        hrEmail
                );

                companyDAO.addCompany(company);
                break;

            // ================= VIEW COMPANIES =================
            case 4:

                List<Company> companies =
                        companyDAO.getAllCompanies();

                System.out.println("\n===== Company List =====");

                if (companies.isEmpty()) {
                    System.out.println("No companies found.");
                } else {

                    for (Company c : companies) {

                        System.out.println(
                                c.getCompanyId() + " | " +
                                c.getCompanyName() + " | " +
                                c.getLocation() + " | " +
                                c.getPackageLpa() + " LPA | " +
                                c.getHrEmail()
                        );
                    }
                }

                break;

            // ================= ADD PLACEMENT =================
            case 5:

                System.out.print("Enter student ID: ");
                int studentId = sc.nextInt();

                if (studentId <= 0) {
                    System.out.println(
                            "Invalid student ID!");
                    break;
                }

                System.out.print("Enter company ID: ");
                int companyId = sc.nextInt();

                if (companyId <= 0) {
                    System.out.println(
                            "Invalid company ID!");
                    break;
                }

                System.out.print("Enter package (LPA): ");
                double placementPackage = sc.nextDouble();

                if (placementPackage <= 0) {
                    System.out.println(
                            "Package must be greater than 0!");
                    break;
                }

                sc.nextLine();

                System.out.print(
                        "Enter placement date (YYYY-MM-DD): ");

                String placementDate = sc.nextLine();

                if (!placementDate.matches(
                        "\\d{4}-\\d{2}-\\d{2}")) {

                    System.out.println(
                            "Invalid date format! Use YYYY-MM-DD.");
                    break;
                }

                System.out.print("Enter status: ");
                String status = sc.nextLine();

                if (status.trim().isEmpty()) {
                    System.out.println(
                            "Status cannot be empty!");
                    break;
                }

                Placement placement = new Placement(
                        0,
                        studentId,
                        companyId,
                        placementPackage,
                        placementDate,
                        status
                );

                placementDAO.addPlacement(placement);
                break;

            // ================= VIEW PLACEMENTS =================
            case 6:

                List<Placement> placements =
                        placementDAO.getAllPlacements();

                System.out.println("\n===== Placement List =====");

                if (placements.isEmpty()) {
                    System.out.println(
                            "No placements found.");
                } else {

                    for (Placement p : placements) {

                        System.out.println(
                                p.getPlacementId() + " | " +
                                p.getStudentId() + " | " +
                                p.getCompanyId() + " | " +
                                p.getPackageLPA() + " LPA | " +
                                p.getPlacementDate() + " | " +
                                p.getStatus()
                        );
                    }
                }

                break;

            // ================= UPDATE PLACEMENT =================
            case 7:

                System.out.print(
                        "Enter placement ID: ");

                int placementId = sc.nextInt();

                if (placementId <= 0) {
                    System.out.println(
                            "Invalid placement ID!");
                    break;
                }

                System.out.print(
                        "Enter student ID: ");

                int updateStudentId = sc.nextInt();

                if (updateStudentId <= 0) {
                    System.out.println(
                            "Invalid student ID!");
                    break;
                }

                System.out.print(
                        "Enter company ID: ");

                int updateCompanyId = sc.nextInt();

                if (updateCompanyId <= 0) {
                    System.out.println(
                            "Invalid company ID!");
                    break;
                }

                System.out.print(
                        "Enter package (LPA): ");

                double updatePackage = sc.nextDouble();

                if (updatePackage <= 0) {
                    System.out.println(
                            "Package must be greater than 0!");
                    break;
                }

                sc.nextLine();

                System.out.print(
                        "Enter placement date (YYYY-MM-DD): ");

                String updateDate = sc.nextLine();

                if (!updateDate.matches(
                        "\\d{4}-\\d{2}-\\d{2}")) {

                    System.out.println(
                            "Invalid date format! Use YYYY-MM-DD.");
                    break;
                }

                System.out.print("Enter status: ");

                String updateStatus = sc.nextLine();

                if (updateStatus.trim().isEmpty()) {
                    System.out.println(
                            "Status cannot be empty!");
                    break;
                }

                placementDAO.updatePlacement(
                        placementId,
                        updateStudentId,
                        updateCompanyId,
                        updatePackage,
                        updateDate,
                        updateStatus
                );

                break;

            // ================= DELETE PLACEMENT =================
            case 8:

                System.out.print(
                        "Enter placement ID to delete: ");

                int deletePlacementId = sc.nextInt();

                if (deletePlacementId <= 0) {
                    System.out.println(
                            "Invalid placement ID!");
                    break;
                }

                placementDAO.deletePlacement(
                        deletePlacementId);

                break;

            // ================= UPDATE STUDENT =================
            case 9:

                System.out.print(
                        "Enter student ID to update: ");

                int studentIdToUpdate = sc.nextInt();

                if (studentIdToUpdate <= 0) {
                    System.out.println(
                            "Invalid student ID!");
                    break;
                }

                sc.nextLine();

                System.out.print("Enter student name: ");

                String updateName = sc.nextLine();

                if (updateName.trim().isEmpty()) {
                    System.out.println(
                            "Name cannot be empty!");
                    break;
                }

                System.out.print("Enter email: ");

                String updateEmail = sc.nextLine();

                if (!updateEmail.contains("@")
                        || !updateEmail.contains(".")) {

                    System.out.println("Invalid email!");
                    break;
                }

                System.out.print("Enter phone: ");

                String updatePhone = sc.nextLine();

                if (!updatePhone.matches("\\d{10}")) {

                    System.out.println(
                            "Phone number must contain 10 digits!");
                    break;
                }

                System.out.print("Enter department: ");

                String updateDepartment = sc.nextLine();

                if (updateDepartment.trim().isEmpty()) {

                    System.out.println(
                            "Department cannot be empty!");
                    break;
                }

                System.out.print("Enter CGPA: ");

                double updateCgpa = sc.nextDouble();

                if (updateCgpa < 0 || updateCgpa > 10) {

                    System.out.println(
                            "Invalid CGPA! CGPA must be between 0 and 10.");
                    break;
                }

                Student updateStudent = new Student(
                        studentIdToUpdate,
                        updateName,
                        updateEmail,
                        updatePhone,
                        updateDepartment,
                        updateCgpa
                );

                studentDAO.updateStudent(updateStudent);

                break;

            // ================= DELETE STUDENT =================
            case 10:

                System.out.print(
                        "Enter student ID to delete: ");

                int studentIdToDelete = sc.nextInt();

                if (studentIdToDelete <= 0) {

                    System.out.println(
                            "Invalid student ID!");
                    break;
                }

                studentDAO.deleteStudent(
                        studentIdToDelete);

                break;

            // ================= UPDATE COMPANY =================
            case 11:

                System.out.print(
                        "Enter company ID to update: ");

                int companyIdToUpdate = sc.nextInt();

                if (companyIdToUpdate <= 0) {

                    System.out.println(
                            "Invalid company ID!");
                    break;
                }

                sc.nextLine();

                System.out.print("Enter company name: ");

                String updateCompanyName =
                        sc.nextLine();

                if (updateCompanyName.trim().isEmpty()) {

                    System.out.println(
                            "Company name cannot be empty!");
                    break;
                }

                System.out.print("Enter location: ");

                String updateCompanyLocation =
                        sc.nextLine();

                if (updateCompanyLocation.trim().isEmpty()) {

                    System.out.println(
                            "Location cannot be empty!");
                    break;
                }

                System.out.print(
                        "Enter package (LPA): ");

                double updateCompanyPackage =
                        sc.nextDouble();

                if (updateCompanyPackage <= 0) {

                    System.out.println(
                            "Package must be greater than 0!");
                    break;
                }

                sc.nextLine();

                System.out.print("Enter HR email: ");

                String updateHrEmail =
                        sc.nextLine();

                if (!updateHrEmail.contains("@")
                        || !updateHrEmail.contains(".")) {

                    System.out.println(
                            "Invalid HR email!");
                    break;
                }

                Company updateCompany = new Company(
                        companyIdToUpdate,
                        updateCompanyName,
                        updateCompanyLocation,
                        updateCompanyPackage,
                        updateHrEmail
                );

                companyDAO.updateCompany(
                        updateCompany);

                break;

            // ================= DELETE COMPANY =================
            case 12:

                System.out.print(
                        "Enter company ID to delete: ");

                int companyIdToDelete =
                        sc.nextInt();

                if (companyIdToDelete <= 0) {

                    System.out.println(
                            "Invalid company ID!");
                    break;
                }

                companyDAO.deleteCompany(
                        companyIdToDelete);

                break;

            // ================= PLACEMENT REPORT =================
            case 13:

                placementDAO.getPlacementReport();

                break;

            // ================= EXIT =================
            case 14:

                System.out.println(
                        "Application closed.");

                sc.close();

                return;

            default:

                System.out.println(
                        "Invalid choice!");
            }
        }
    }
}
