package com.ogrenciyonetim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends BaseEntity {

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_type")
    private String subjectType; 
    
    
    @Column(name = "day")
    private String day; 

    @Column(name = "start_time")
    private String startTime; 

    @Column(name = "finish_time")
    private String finishTime;

    @Column(name = "class_no")
    private int classNo; 

    @Column(name = "credit")
    private int credit;


}
