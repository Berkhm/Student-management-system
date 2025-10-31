<<<<<<< HEAD
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestGradeController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.service.IGradeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/grade")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GradeController extends RestBaseController implements IRestGradeController {

    @Autowired
    private IGradeService gradeService;

    @Override
    @GetMapping("/findAll/{studentId}")
    public RootEntity<List<DtoGrade>> getGradesByStudentId(@PathVariable("studentId") Long studentId) {
        return ok(gradeService.getGradesByStudentId(studentId));
    }

    @Override
    @GetMapping("/find/{id}")
    public RootEntity<DtoGrade> getGradeById(@PathVariable("id") Long id) {
        return ok(gradeService.getGradeById(id));
    }

    @Override
    @PostMapping("/save")
    public RootEntity<DtoGrade> saveGrade(@Valid @RequestBody DtoGradeIU dtoGradeIU) {
        return ok(gradeService.saveGrade(dtoGradeIU));
    }

    @Override
    @PostMapping("/update/{id}")
    public RootEntity<DtoGrade> updateGrade(@PathVariable("id") Long id,
                                            @Valid @RequestBody DtoGradeIU dtoGradeIU) {
        return ok(gradeService.updateGrade(id, dtoGradeIU));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RootEntity<String> deleteGrade(@PathVariable("id") Long id) {
        gradeService.deleteGrade(id);
        return ok("Silme işlemi başarılı");
    }
}
=======
package com.ogrenciyonetim.controller.Impl;

import com.ogrenciyonetim.controller.IRestGradeController;
import com.ogrenciyonetim.controller.RestBaseController;
import com.ogrenciyonetim.controller.RootEntity;
import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.service.IGradeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/grade")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class GradeController extends RestBaseController implements IRestGradeController {

    @Autowired
    private IGradeService gradeService;

    @Override
    @GetMapping("/findAll/{studentId}")
    public RootEntity<List<DtoGrade>> getGradesByStudentId(@PathVariable("studentId") Long studentId) {
        return ok(gradeService.getGradesByStudentId(studentId));
    }

    @Override
    @GetMapping("/find/{id}")
    public RootEntity<DtoGrade> getGradeById(@PathVariable("id") Long id) {
        return ok(gradeService.getGradeById(id));
    }

    @Override
    @PostMapping("/save")
    public RootEntity<DtoGrade> saveGrade(@Valid @RequestBody DtoGradeIU dtoGradeIU) {
        return ok(gradeService.saveGrade(dtoGradeIU));
    }

    @Override
    @PostMapping("/update/{id}")
    public RootEntity<DtoGrade> updateGrade(@PathVariable("id") Long id,
                                            @Valid @RequestBody DtoGradeIU dtoGradeIU) {
        return ok(gradeService.updateGrade(id, dtoGradeIU));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public RootEntity<String> deleteGrade(@PathVariable("id") Long id) {
        gradeService.deleteGrade(id);
        return ok("Silme işlemi başarılı");
    }
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
