package com.ogrenciyonetim.controller;

import java.util.List;

import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.model.Grade;

public interface IRestGradeController {
	

	   public RootEntity<List<DtoGrade>> getGradesByStudentId(Long id);
	   
	   public RootEntity<DtoGrade> getGradeById(Long id);
	   
	   public RootEntity<DtoGrade> saveGrade(DtoGradeIU dtoGradeIU);
	   
	   public RootEntity<DtoGrade> updateGrade(Long id, DtoGradeIU dtoGradeIU);
	   
	   public RootEntity<String> deleteGrade(Long id);

}
