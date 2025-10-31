package com.ogrenciyonetim.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenciyonetim.dto.DtoGrade;
import com.ogrenciyonetim.dto.DtoGradeIU;
import com.ogrenciyonetim.model.Grade;
import com.ogrenciyonetim.model.Student;
import com.ogrenciyonetim.repository.IGradeRepository;
import com.ogrenciyonetim.repository.IStudentRepository;
import com.ogrenciyonetim.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private IGradeRepository gradeRepository;

    @Autowired
    private IStudentRepository studentRepository;

    private Grade createGrade(DtoGradeIU iu) {
        Grade grade = new Grade();
        grade.setCreateTime(new Date());
        BeanUtils.copyProperties(iu, grade);
        Student student = studentRepository.findById(iu.getStudentId())
            .orElseThrow(() -> new IllegalArgumentException("Student not found: " + iu.getStudentId()));
        
        grade.setStudent(student);
        return grade;
    }

    @Override
    public List<DtoGrade> getGradesByStudentId(Long studentId) {
    	
     studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentId));
    	
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        List<DtoGrade> dtoGrades = new ArrayList<>();
        for (Grade g : grades) {
            DtoGrade dto = new DtoGrade();
            BeanUtils.copyProperties(g, dto, "student");
            dto.setStudentId(g.getStudent().getId());
            dtoGrades.add(dto);
        }
        return dtoGrades;
    }

    @Override
    public DtoGrade getGradeById(Long id) {
        Grade g = gradeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Grade not found: " + id));
        DtoGrade dto = new DtoGrade();
        BeanUtils.copyProperties(g, dto);
        dto.setStudentId(g.getStudent().getId());
        return dto;
    }

    @Override
    public DtoGrade saveGrade(DtoGradeIU iu) {
    	studentRepository.findById(iu.getStudentId()) .orElseThrow(() -> new IllegalArgumentException("Student not found: " + iu.getStudentId()));
        Grade saved = gradeRepository.save(createGrade(iu));
        DtoGrade dto = new DtoGrade();
        BeanUtils.copyProperties(saved, dto);
        dto.setStudentId(saved.getStudent().getId());
        return dto;
    }

    @Override
    public DtoGrade updateGrade(Long id, DtoGradeIU iu) {
        Grade existing = gradeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Grade not found: " + id));
        
        BeanUtils.copyProperties(iu, existing);
        Student student = studentRepository.findById(iu.getStudentId())
            .orElseThrow(() -> new IllegalArgumentException("Student not found: " + iu.getStudentId()));
        
        
        existing.setStudent(student);
        Grade saved = gradeRepository.save(existing);
        DtoGrade dto = new DtoGrade();
        BeanUtils.copyProperties(saved, dto, "student");
        dto.setStudentId(saved.getStudent().getId());
        return dto;
    }

    @Override
    public void deleteGrade(Long id) {
    	gradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Grade not found: " + id));
        gradeRepository.deleteById(id);
    }
}
