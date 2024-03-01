package com.company.entity;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="empolyeeDetails")
public class Empolyee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="salary")
    private double salary;
    @Column(name="content")
    private String content;

}
