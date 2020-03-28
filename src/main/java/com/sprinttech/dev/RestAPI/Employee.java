package com.sprinttech.dev.RestAPI;

public class Employee {
    public Employee(Integer Id, String firstName, String lastName, String email) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private Integer Id;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println(lastName);
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

    private String lastName;
    private String email;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {

        System.out.println(id);
        Id = id;
    }

     @Override
    public String toString() {
        return " Employee [Id =" + Id + ", FirstName =" + firstName + ", LastName =" + lastName + ", email =" + email +"]";
    }
}

