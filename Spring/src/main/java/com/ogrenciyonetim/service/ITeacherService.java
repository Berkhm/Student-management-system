<<<<<<< HEAD
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;
import com.ogrenciyonetim.model.Teacher;

import java.util.List;

public interface ITeacherService {
	public List<DtoTeacher> getAllTeachers();
	public DtoTeacher getTeacherById(Long id);
	public DtoTeacher saveTeacher(DtoTeacherIU dtoTeacherIU);
	public DtoTeacher updateTeacher(Long id, DtoTeacherIU dtoTeacherIU);
	public  void deleteTeacher(Long id);
}
=======
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;
import com.ogrenciyonetim.model.Teacher;

import java.util.List;

public interface ITeacherService {
	public List<DtoTeacher> getAllTeachers();
	public DtoTeacher getTeacherById(Long id);
	public DtoTeacher saveTeacher(DtoTeacherIU dtoTeacherIU);
	public DtoTeacher updateTeacher(Long id, DtoTeacherIU dtoTeacherIU);
	public  void deleteTeacher(Long id);
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
