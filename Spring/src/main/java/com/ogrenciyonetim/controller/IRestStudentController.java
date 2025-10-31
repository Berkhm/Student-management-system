package com.ogrenciyonetim.controller;

import java.util.List;

import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.model.Grade;

public interface IRestStudentController {
	
	

	   public RootEntity<List<DtoStudent>> getAllStudents();
	   
	   public RootEntity<DtoStudent> getStudentById(Long id);
	   
	   public RootEntity<DtoStudent> saveStudent(DtoStudentIU dtoStudentIU);
	   
	   public RootEntity<DtoStudent> updateStudent(Long id, DtoStudentIU dtoStudentIU);
	   
	   public RootEntity<String> deleteStudent(Long id);

}
