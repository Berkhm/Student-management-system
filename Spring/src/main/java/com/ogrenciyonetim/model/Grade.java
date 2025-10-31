package com.ogrenciyonetim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade extends BaseEntity{
	
	 @Column(name = "subject_name")
	private String subjectName;
    
    @Column(name = "midterm")
    private double midterm;
    
    @Column(name = "final")
    private double finalExam; 
    
    @Column(name = "average")
    private double average;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @Column(name = "letter_grade")
    private String letterGrade;

}
