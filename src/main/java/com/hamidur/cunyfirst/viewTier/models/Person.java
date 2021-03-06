package com.hamidur.cunyfirst.viewTier.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Person implements Serializable
{
    @NotNull(message = "First name must be provided")
    @Size(min = 1, max = 15)
    private String firstName;
    
    @Size(min = 1, max = 15)
    private String lastName;
    
    @NotNull(message = "SSN must be provided")
    @Size(min = 9, max = 9)
    private String ssn;
    
    @NotNull(message = "Date of birth cannot be empty")
    private String dateOfBirth;
    
    @NotNull(message = "String must be provided")
    @Size(min = 1, max = 1)
    private String gender;
    
    public Person() {}
    
    public Person(String firstName, String lastName, String ssn, String dateOfBirth, String gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getSsn()
    {
        return ssn;
    }
    
    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }
    
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public java.lang.String toString() {
        return "Person{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", ssn=" + ssn +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
