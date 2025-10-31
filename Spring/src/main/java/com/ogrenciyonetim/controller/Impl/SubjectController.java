<<<<<<< HEAD
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestSubjectController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;
import com.ogrenciyonetim.service.ISubjectService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/subject")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SubjectController extends RestBaseController implements IRestSubjectController {

    @Autowired
    private ISubjectService subjectService;

    @Override
    @GetMapping(path = "/findAll")
    public RootEntity<List<DtoSubject>> getAllSubjects() {
   
        return ok(subjectService.getAllSubjects());
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public RootEntity<DtoSubject> getSubjectById(@PathVariable("id") Long id) {
        return ok(subjectService.getSubjectById(id));
    }

    @Override
    @PostMapping(path = "/save")
    public RootEntity<DtoSubject> saveSubject(@Valid @RequestBody DtoSubjectIU dtoSubjectIU) {
      
        return ok(subjectService.saveSubject(dtoSubjectIU));
    }

    @Override
    @PostMapping(path = "/update/{id}")
    public RootEntity<DtoSubject> updateSubject(@PathVariable("id") Long id,
                                                @Valid @RequestBody DtoSubjectIU dtoSubjectIU) {
      
        return ok(subjectService.updateSubject(id, dtoSubjectIU));
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public RootEntity<String> deleteSubject(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
        return ok("Silme işlemi başarılı");
    }
}
=======
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestSubjectController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;
import com.ogrenciyonetim.service.ISubjectService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/subject")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SubjectController extends RestBaseController implements IRestSubjectController {

    @Autowired
    private ISubjectService subjectService;

    @Override
    @GetMapping(path = "/findAll")
    public RootEntity<List<DtoSubject>> getAllSubjects() {
   
        return ok(subjectService.getAllSubjects());
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public RootEntity<DtoSubject> getSubjectById(@PathVariable("id") Long id) {
        return ok(subjectService.getSubjectById(id));
    }

    @Override
    @PostMapping(path = "/save")
    public RootEntity<DtoSubject> saveSubject(@Valid @RequestBody DtoSubjectIU dtoSubjectIU) {
      
        return ok(subjectService.saveSubject(dtoSubjectIU));
    }

    @Override
    @PostMapping(path = "/update/{id}")
    public RootEntity<DtoSubject> updateSubject(@PathVariable("id") Long id,
                                                @Valid @RequestBody DtoSubjectIU dtoSubjectIU) {
      
        return ok(subjectService.updateSubject(id, dtoSubjectIU));
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public RootEntity<String> deleteSubject(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
        return ok("Silme işlemi başarılı");
    }
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
