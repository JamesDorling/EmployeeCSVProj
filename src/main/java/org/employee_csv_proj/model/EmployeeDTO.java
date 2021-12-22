package org.employee_csv_proj.model;

import org.employee_csv_proj.logging.MyLogger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public class EmployeeDTO {
    //Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
    private int empID;
    private String title;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private LocalDate dob;
    private LocalDate dateJoined;
    private int salary;

    public EmployeeDTO(String[] employeeData) {
        this.setEmpID(Integer.parseInt(employeeData[0]));
        this.setTitle(employeeData[1]);
        this.setFirstName(employeeData[2]);
        this.setMiddleInitial(employeeData[3].charAt(0));
        this.setLastName(employeeData[4]);
        this.setGender(employeeData[5].charAt(0));
        this.setEmail(employeeData[6]);
        this.setDob(employeeData[7]);
        this.setDateJoined(employeeData[8]);
        this.setSalary(Integer.parseInt(employeeData[9]));
    }

    public EmployeeDTO(ResultSet employeeData) {
        try {
            employeeData.next();
            this.setEmpID(employeeData.getInt(1));
            this.setTitle(employeeData.getString(2));
            this.setFirstName(employeeData.getString(3));
            this.setMiddleInitial(employeeData.getString(4).charAt(0));
            this.setLastName(employeeData.getString(5));
            this.setGender(employeeData.getString(6).charAt(0));
            this.setEmail(employeeData.getString(7));

            this.setDobFromDatabase(employeeData.getString(8));
            this.setDateJoinedFromDatabase(employeeData.getString(9));

            this.setSalary(employeeData.getInt(10));
        } catch (SQLException e) {
            MyLogger.log(Level.SEVERE, "Missing data on employee!");
        }
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int ID) {
        this.empID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public void setDobFromDatabase(String dob) {
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-M[M]-d[d]"));
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = LocalDate.parse(dateJoined, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public void setDateJoinedFromDatabase(String dateJoined) {
        this.dateJoined = LocalDate.parse(dateJoined, DateTimeFormatter.ofPattern("yyyy-M[M]-d[d]"));
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        System.out.println("Employee details: \n");
        return  "empID=" + empID +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", dateJoined=" + dateJoined +
                ", salary=" + salary;
    }
}
