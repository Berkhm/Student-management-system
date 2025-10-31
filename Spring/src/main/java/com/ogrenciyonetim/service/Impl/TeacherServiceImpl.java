package com.ogrenciyonetim.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenciyonetim.dto.DtoTeacher;
import com.ogrenciyonetim.dto.DtoTeacherIU;
import com.ogrenciyonetim.model.Teacher;
import com.ogrenciyonetim.repository.ITeacherRepository;
import com.ogrenciyonetim.service.ITeacherService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private ITeacherRepository teacherRepository;

 
    private Teacher createTeacher(DtoTeacherIU iu) {
        Teacher teacher = new Teacher();
        teacher.setCreateTime(new Date());
        BeanUtils.copyProperties(iu, teacher);
        return teacher;
    }

    @Override
    public List<DtoTeacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<DtoTeacher> dtoList = new ArrayList<>();
        for (Teacher teacher : teachers) {
            DtoTeacher dto = new DtoTeacher();
            BeanUtils.copyProperties(teacher, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoTeacher getTeacherById(Long id) {
        Optional<Teacher> opt = teacherRepository.findById(id);
        DtoTeacher dto = new DtoTeacher();
        BeanUtils.copyProperties(opt.get(), dto);
        return dto;
    }

    @Override
    public DtoTeacher saveTeacher(DtoTeacherIU dtoTeacherIU) {
        Teacher saved = teacherRepository.save(createTeacher(dtoTeacherIU));
        DtoTeacher dto = new DtoTeacher();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    public DtoTeacher updateTeacher(Long id, DtoTeacherIU iu) {
        Teacher existing = teacherRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Teacher not found: " + id));

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
        if (iu.getTitle() != null && !iu.getTitle().isEmpty()) {
            existing.setTitle(iu.getTitle());
        }
        if (iu.getMajor() != null && !iu.getMajor().isEmpty()) {
            existing.setMajor(iu.getMajor());
        }

        Teacher saved = teacherRepository.save(existing);

        DtoTeacher dto = new DtoTeacher();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    public void deleteTeacher(Long id) {
    	teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Teacher not found: " + id));
    	
        teacherRepository.deleteById(id);
    }
}
