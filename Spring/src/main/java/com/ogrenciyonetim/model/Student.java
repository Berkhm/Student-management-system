package com.ogrenciyonetim.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    @ManyToOne
    private Teacher advisor;
    
    @OneToMany
    private List<Grade> grades;
   
    @Column(name = "student_no")
    private String studentNo;
    
    @Column(name = "grade_year")
    private int gradeYear;
    
    @Column(name = "gpa")
    private double gpa;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "discontinuity_days")
    private int discontinuityDays; 

}
