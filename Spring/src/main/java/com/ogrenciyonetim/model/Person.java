package com.ogrenciyonetim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    private String name;
    
    private String mail;
    
    private String faculty;
    
    private String telNo;
    
    private String address;

}
