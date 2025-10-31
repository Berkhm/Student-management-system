package com.ogrenciyonetim.controller;

import java.util.List;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;

public interface IRestSubjectController {
	


	   public RootEntity<List<DtoSubject>> getAllSubjects();
	   
	   public RootEntity<DtoSubject> getSubjectById(Long id);
	   
	   public RootEntity<DtoSubject> saveSubject(DtoSubjectIU dtoSubjectIU);
	   
	   public RootEntity<DtoSubject> updateSubject(Long id, DtoSubjectIU dtoSubjectIU);
	   
	   public RootEntity<String> deleteSubject(Long id);

}
