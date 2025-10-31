<<<<<<< HEAD
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.model.Student;

import java.util.List;

public interface IStudentService {
	public List<DtoStudent> getAllStudents();
	public DtoStudent getStudentById(Long id);
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public  DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
	public void deleteStudent(Long id);
}
=======
package com.ogrenciyonetim.service;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.model.Student;

import java.util.List;

public interface IStudentService {
	public List<DtoStudent> getAllStudents();
	public DtoStudent getStudentById(Long id);
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	public  DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
	public void deleteStudent(Long id);
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
