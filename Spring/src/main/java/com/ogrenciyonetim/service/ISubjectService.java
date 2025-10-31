<<<<<<< HEAD
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;
import com.ogrenciyonetim.model.Subject;

import java.util.List;

public interface ISubjectService {
	public List<DtoSubject> getAllSubjects();
	public  DtoSubject getSubjectById(Long id);
	public DtoSubject saveSubject(DtoSubjectIU dtoSubjectIU);
	public DtoSubject updateSubject(Long id, DtoSubjectIU dtoSubjectIU);
	public void deleteSubject(Long id);
}
=======
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;
import com.ogrenciyonetim.model.Subject;

import java.util.List;

public interface ISubjectService {
	public List<DtoSubject> getAllSubjects();
	public  DtoSubject getSubjectById(Long id);
	public DtoSubject saveSubject(DtoSubjectIU dtoSubjectIU);
	public DtoSubject updateSubject(Long id, DtoSubjectIU dtoSubjectIU);
	public void deleteSubject(Long id);
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
