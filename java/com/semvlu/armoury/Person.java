package com.semvlu.armoury;

import jakarta.persistence.*;

import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private String id;

    private String name;
    private Integer Company;
    private Date dob;
    private String status;

    @Transient
    private Integer age;

    public Person() {}
    public Person(String id, String name, Integer company, Date dob, String status) {
        this.id = id;
        this.name = name;
        Company = company;
        this.dob = dob;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompany() {
        return Company;
    }

    public void setCompany(Integer company) {
        Company = company;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAge() {
        return Period.between(dob.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate(),
                java.time.LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Company=" + Company +
                ", dob=" + dob +
                ", status='" + status + '\'' +
                ", age=" + age +
                '}';
    }
}
