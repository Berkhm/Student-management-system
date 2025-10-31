package com.ogrenciyonetim.controller;

import java.util.List;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;

public interface IRestTeacherController {
	


	   public RootEntity<List<DtoTeacher>> getAllTeachers();
	   
	   public RootEntity<DtoTeacher> getTeacherById(Long id);
	   
	   public RootEntity<DtoTeacher> saveTeacher(DtoTeacherIU dtoTeacherIU);
	   
	   public RootEntity<DtoTeacher> updateTeacher(Long id, DtoTeacherIU dtoTeacherIU);
	   
	   public RootEntity<String> deleteTeacher(Long id);

}
