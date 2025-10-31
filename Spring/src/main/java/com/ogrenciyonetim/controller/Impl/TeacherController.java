<<<<<<< HEAD
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestTeacherController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;
import com.ogrenciyonetim.service.ITeacherService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/teacher")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TeacherController extends RestBaseController implements IRestTeacherController {

	@Autowired
	private ITeacherService teacherService;
	
	@Override
	@GetMapping(path = "/findAll")
	public RootEntity<List<DtoTeacher>> getAllTeachers() {
		
		return ok(teacherService.getAllTeachers());
	}

	@Override
	@GetMapping(path = "/find/{id}")
	public RootEntity<DtoTeacher> getTeacherById(@PathVariable(name = "id")  Long id) {
		return ok(teacherService.getTeacherById(id));
	}

	@Override
	@PostMapping(path = "/save")
	public RootEntity<DtoTeacher> saveTeacher(@Valid @RequestBody DtoTeacherIU dtoTeacherIU) {
		return ok(teacherService.saveTeacher(dtoTeacherIU));
	}

	@Override
	@PostMapping(path = "/update/{id}")
	public RootEntity<DtoTeacher> updateTeacher(@PathVariable(name = "id") Long id, @RequestBody DtoTeacherIU dtoTeacherIU) {

		return ok(teacherService.updateTeacher(id, dtoTeacherIU));
	}

	@Override
	@DeleteMapping(path =  "/delete/{id}")
	public RootEntity<String> deleteTeacher(@PathVariable(name = "id") Long id) {
		teacherService.deleteTeacher(id);
		return ok("Silme işlemi başarılı");
	}

  
}
=======
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestTeacherController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;
import com.ogrenciyonetim.service.ITeacherService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/api/teacher")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TeacherController extends RestBaseController implements IRestTeacherController {

	@Autowired
	private ITeacherService teacherService;
	
	@Override
	@GetMapping(path = "/findAll")
	public RootEntity<List<DtoTeacher>> getAllTeachers() {
		
		return ok(teacherService.getAllTeachers());
	}

	@Override
	@GetMapping(path = "/find/{id}")
	public RootEntity<DtoTeacher> getTeacherById(@PathVariable(name = "id")  Long id) {
		return ok(teacherService.getTeacherById(id));
	}

	@Override
	@PostMapping(path = "/save")
	public RootEntity<DtoTeacher> saveTeacher(@Valid @RequestBody DtoTeacherIU dtoTeacherIU) {
		return ok(teacherService.saveTeacher(dtoTeacherIU));
	}

	@Override
	@PostMapping(path = "/update/{id}")
	public RootEntity<DtoTeacher> updateTeacher(@PathVariable(name = "id") Long id, @RequestBody DtoTeacherIU dtoTeacherIU) {

		return ok(teacherService.updateTeacher(id, dtoTeacherIU));
	}

	@Override
	@DeleteMapping(path =  "/delete/{id}")
	public RootEntity<String> deleteTeacher(@PathVariable(name = "id") Long id) {
		teacherService.deleteTeacher(id);
		return ok("Silme işlemi başarılı");
	}

  
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
