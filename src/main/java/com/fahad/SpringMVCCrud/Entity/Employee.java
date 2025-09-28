package com.fahad.SpringMVCCrud.Entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "dob", nullable = false)
    private Instant dob; 

    private String department;

    public Employee() {}

    public Employee(String name, String email, Instant dob, String department) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

  
}