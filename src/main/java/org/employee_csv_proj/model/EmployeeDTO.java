package org.employee_csv_proj.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {
    //Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
    private int ID;
    private String title;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private LocalDate dob; //Change to localdate?
    private LocalDate dateJoined;
    private int Salary;

    public EmployeeDTO(String[] employeeData) {
        this.setID(Integer.parseInt(employeeData[0]));
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = LocalDate.parse(dateJoined, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
