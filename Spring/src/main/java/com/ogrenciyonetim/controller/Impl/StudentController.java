<<<<<<< HEAD
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestStudentController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.service.IStudentService;
import com.ogrenciyonetim.service.Impl.StudentServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController extends RestBaseController implements IRestStudentController {

    @Autowired
    private IStudentService studentService;

    @Override
    @GetMapping("/findAll")
    public RootEntity<List<DtoStudent>> getAllStudents() {
        return ok(studentService.getAllStudents());
    }

    @Override
    @GetMapping("/find/{id}")
    public RootEntity<DtoStudent> getStudentById(@PathVariable("id") Long id) {
        return ok(studentService.getStudentById(id));
    }

    @Override
    @PostMapping("/save")
    public RootEntity<DtoStudent> saveStudent(@Valid @RequestBody DtoStudentIU dtoStudentIU) {
        return ok(studentService.saveStudent(dtoStudentIU));
    }

    @Override
    @PostMapping("/update/{id}")
    public RootEntity<DtoStudent> updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody DtoStudentIU dtoStudentIU) {
        return ok(studentService.updateStudent(id, dtoStudentIU));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RootEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ok("Silme işlemi başarılı");
    }
}
=======
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestStudentController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.service.IStudentService;
import com.ogrenciyonetim.service.Impl.StudentServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController extends RestBaseController implements IRestStudentController {

    @Autowired
    private IStudentService studentService;

    @Override
    @GetMapping("/findAll")
    public RootEntity<List<DtoStudent>> getAllStudents() {
        return ok(studentService.getAllStudents());
    }

    @Override
    @GetMapping("/find/{id}")
    public RootEntity<DtoStudent> getStudentById(@PathVariable("id") Long id) {
        return ok(studentService.getStudentById(id));
    }

    @Override
    @PostMapping("/save")
    public RootEntity<DtoStudent> saveStudent(@Valid @RequestBody DtoStudentIU dtoStudentIU) {
        return ok(studentService.saveStudent(dtoStudentIU));
    }

    @Override
    @PostMapping("/update/{id}")
    public RootEntity<DtoStudent> updateStudent(@PathVariable("id") Long id,
                                                 @RequestBody DtoStudentIU dtoStudentIU) {
        return ok(studentService.updateStudent(id, dtoStudentIU));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RootEntity<String> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ok("Silme işlemi başarılı");
    }
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
