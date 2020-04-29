package com.sprinttech.dev.RestAPI;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection= "Employee")
public class Employee {
    public Employee(String empId,String firstName, String lastName, String email) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    private String  empId;
    private String firstName;
    private String lastName;
    private String email;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     @Override
    public String toString() {
        return "Employee [EmployeeID = "+ empId + ", FirstName =" + firstName + ", LastName =" + lastName + ", email =" + email +"]";
    }
}

