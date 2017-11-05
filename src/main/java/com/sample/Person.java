package com.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PERSON")
public class Person
{

    @Id
    @Column(name = "ID")
    @NotNull
    private Integer id;

    private String name;

    private String email;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CREATION_DATE",length=100)
    private String date;

    private boolean active;


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getJobTitle()
    {
        return jobTitle;
    }


    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


    public String getDate()
    {
        return date;
    }


    public void setDate(String date)
    {
        this.date = date;
    }


    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public Person()
    {
        super();
    }
    
    public Person(Integer id, String name, String email, String jobTitle, String phoneNumber, String date, boolean active)
    {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.active = active;
    }


    public Integer getId()
    {
        return id;
    }


    public void setId(Integer id)
    {
        this.id = id;
    }


    public Person(String name, String email, String jobTitle, String phoneNumber, String date, boolean active)
    {
        super();
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.active = active;
    }
}
