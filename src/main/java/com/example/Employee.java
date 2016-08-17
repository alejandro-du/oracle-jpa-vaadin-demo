package com.example;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @SequenceGenerator(name = "EmployeeSeq", sequenceName = "employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeSeq")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
