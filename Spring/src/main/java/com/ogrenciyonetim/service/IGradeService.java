<<<<<<< HEAD
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.model.Grade;

import java.util.List;

public interface IGradeService {
	
	public List<DtoGrade> getGradesByStudentId(Long studentId);
   public DtoGrade getGradeById(Long id);
   public DtoGrade saveGrade(DtoGradeIU dtoGradeIU);
   public DtoGrade updateGrade(Long id, DtoGradeIU dtoGradeIU);
   public void deleteGrade(Long id);
}
=======
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.model.Grade;

import java.util.List;

public interface IGradeService {
	
	public List<DtoGrade> getGradesByStudentId(Long studentId);
   public DtoGrade getGradeById(Long id);
   public DtoGrade saveGrade(DtoGradeIU dtoGradeIU);
   public DtoGrade updateGrade(Long id, DtoGradeIU dtoGradeIU);
   public void deleteGrade(Long id);
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
