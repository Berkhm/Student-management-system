<<<<<<< HEAD
package com.ogrenciyonetim.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.model.Student;
import com.ogrenciyonetim.model.Teacher;
import com.ogrenciyonetim.repository.IGradeRepository;
import com.ogrenciyonetim.repository.IStudentRepository;
import com.ogrenciyonetim.repository.ITeacherRepository;
import com.ogrenciyonetim.service.IStudentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ITeacherRepository teacherRepository;
    
    @Autowired
    private IGradeRepository gradeRepository;

    public Student createStudent(DtoStudentIU iu) {
        Student student = new Student();
        student.setCreateTime(new Date());
        BeanUtils.copyProperties(iu, student);
        Teacher advisor = teacherRepository.findById(iu.getAdvisorId()).orElseThrow(() -> new EntityNotFoundException("Teacher not found: " + iu.getAdvisorId()));
        student.setAdvisor(advisor);
        return student;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<DtoStudent> dtoList = new ArrayList<>();
        for (Student s : students) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(s, dto);
            dto.setAdvisorName(s.getAdvisor().getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
    	Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
        DtoStudent dto = new DtoStudent();
        BeanUtils.copyProperties(s, dto);
        dto.setAdvisorName(s.getAdvisor().getName());
        return dto;
    }

    @Override
    public DtoStudent saveStudent(DtoStudentIU iu) {
        Student saved = studentRepository.save(createStudent(iu));
        DtoStudent dto = new DtoStudent();
        BeanUtils.copyProperties(saved, dto);
        dto.setAdvisorName(saved.getAdvisor().getName());
        return dto;
    }

    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU iu) {
    	
    	Student existing = studentRepository.findById(id)
    	        .orElseThrow(() -> new EntityNotFoundException("Student not found: " + id));

    	    // — String alanlar: null veya boş değilse kopyala —
    	    if (iu.getName() != null && !iu.getName().isEmpty()) {
    	        existing.setName(iu.getName());
    	    }
    	    if (iu.getMail() != null && !iu.getMail().isEmpty()) {
    	        existing.setMail(iu.getMail());
    	    }
    	    if (iu.getFaculty() != null && !iu.getFaculty().isEmpty()) {
    	        existing.setFaculty(iu.getFaculty());
    	    }
    	    if (iu.getTelNo() != null && !iu.getTelNo().isEmpty()) {
    	        existing.setTelNo(iu.getTelNo());
    	    }
    	    if (iu.getAddress() != null && !iu.getAddress().isEmpty()) {
    	        existing.setAddress(iu.getAddress());
    	    }
    	    if (iu.getStudentNo() != null && !iu.getStudentNo().isEmpty()) {
    	        existing.setStudentNo(iu.getStudentNo());
    	    }
    	    if (iu.getDepartment() != null && !iu.getDepartment().isEmpty()) {
    	        existing.setDepartment(iu.getDepartment());
    	    }

    	    if (iu.getGradeYear() != null) {
    	        existing.setGradeYear(iu.getGradeYear());
    	    }
    	    if (iu.getGpa() != null) {
    	        existing.setGpa(iu.getGpa());
    	    }
    	    if (iu.getDiscontinuityDays() != null) {
    	        existing.setDiscontinuityDays(iu.getDiscontinuityDays());
    	    }

    	    if (iu.getAdvisorId() != null && iu.getAdvisorId() > 0) {
    	        Teacher advisor = teacherRepository.findById(iu.getAdvisorId())
    	            .orElseThrow(() -> new IllegalArgumentException("Advisor not found: " + iu.getAdvisorId()));
    	        existing.setAdvisor(advisor);
    	    }
    	
    	    
    	    Student updated = studentRepository.save(existing);

    	    DtoStudent dto = new DtoStudent();
    	    BeanUtils.copyProperties(updated, dto);
    	    dto.setAdvisorName(updated.getAdvisor().getName());
    	    return dto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
        // KONTROL EDİYORUM BURADA YOKSA EXCEPİTON FIRLATSIN SİSTEM ÇÖKMESİN
    	gradeRepository.deleteByStudentId(id);
        studentRepository.deleteById(id);
    }
}
=======
package com.ogrenciyonetim.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenciyonetim.dto.DtoStudent;
import com.ogrenciyonetim.dto.DtoStudentIU;
import com.ogrenciyonetim.model.Student;
import com.ogrenciyonetim.model.Teacher;
import com.ogrenciyonetim.repository.IGradeRepository;
import com.ogrenciyonetim.repository.IStudentRepository;
import com.ogrenciyonetim.repository.ITeacherRepository;
import com.ogrenciyonetim.service.IStudentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ITeacherRepository teacherRepository;
    
    @Autowired
    private IGradeRepository gradeRepository;

    public Student createStudent(DtoStudentIU iu) {
        Student student = new Student();
        student.setCreateTime(new Date());
        BeanUtils.copyProperties(iu, student);
        Teacher advisor = teacherRepository.findById(iu.getAdvisorId()).orElseThrow(() -> new EntityNotFoundException("Teacher not found: " + iu.getAdvisorId()));
        student.setAdvisor(advisor);
        return student;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<DtoStudent> dtoList = new ArrayList<>();
        for (Student s : students) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(s, dto);
            dto.setAdvisorName(s.getAdvisor().getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
    	Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
        DtoStudent dto = new DtoStudent();
        BeanUtils.copyProperties(s, dto);
        dto.setAdvisorName(s.getAdvisor().getName());
        return dto;
    }

    @Override
    public DtoStudent saveStudent(DtoStudentIU iu) {
        Student saved = studentRepository.save(createStudent(iu));
        DtoStudent dto = new DtoStudent();
        BeanUtils.copyProperties(saved, dto);
        dto.setAdvisorName(saved.getAdvisor().getName());
        return dto;
    }

    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU iu) {
    	
    	Student existing = studentRepository.findById(id)
    	        .orElseThrow(() -> new EntityNotFoundException("Student not found: " + id));

    	    // — String alanlar: null veya boş değilse kopyala —
    	    if (iu.getName() != null && !iu.getName().isEmpty()) {
    	        existing.setName(iu.getName());
    	    }
    	    if (iu.getMail() != null && !iu.getMail().isEmpty()) {
    	        existing.setMail(iu.getMail());
    	    }
    	    if (iu.getFaculty() != null && !iu.getFaculty().isEmpty()) {
    	        existing.setFaculty(iu.getFaculty());
    	    }
    	    if (iu.getTelNo() != null && !iu.getTelNo().isEmpty()) {
    	        existing.setTelNo(iu.getTelNo());
    	    }
    	    if (iu.getAddress() != null && !iu.getAddress().isEmpty()) {
    	        existing.setAddress(iu.getAddress());
    	    }
    	    if (iu.getStudentNo() != null && !iu.getStudentNo().isEmpty()) {
    	        existing.setStudentNo(iu.getStudentNo());
    	    }
    	    if (iu.getDepartment() != null && !iu.getDepartment().isEmpty()) {
    	        existing.setDepartment(iu.getDepartment());
    	    }

    	    if (iu.getGradeYear() != null) {
    	        existing.setGradeYear(iu.getGradeYear());
    	    }
    	    if (iu.getGpa() != null) {
    	        existing.setGpa(iu.getGpa());
    	    }
    	    if (iu.getDiscontinuityDays() != null) {
    	        existing.setDiscontinuityDays(iu.getDiscontinuityDays());
    	    }

    	    if (iu.getAdvisorId() != null && iu.getAdvisorId() > 0) {
    	        Teacher advisor = teacherRepository.findById(iu.getAdvisorId())
    	            .orElseThrow(() -> new IllegalArgumentException("Advisor not found: " + iu.getAdvisorId()));
    	        existing.setAdvisor(advisor);
    	    }
    	
    	    
    	    Student updated = studentRepository.save(existing);

    	    DtoStudent dto = new DtoStudent();
    	    BeanUtils.copyProperties(updated, dto);
    	    dto.setAdvisorName(updated.getAdvisor().getName());
    	    return dto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
        // KONTROL EDİYORUM BURADA YOKSA EXCEPİTON FIRLATSIN SİSTEM ÇÖKMESİN
    	gradeRepository.deleteByStudentId(id);
        studentRepository.deleteById(id);
    }
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
