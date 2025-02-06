package com.ems.employeemanagement.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
