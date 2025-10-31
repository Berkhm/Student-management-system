package com.ogrenciyonetim.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogrenciyonetim.dto.DtoSubject;
import com.ogrenciyonetim.dto.DtoSubjectIU;
import com.ogrenciyonetim.model.Subject;
import com.ogrenciyonetim.repository.ISubjectRepository;
import com.ogrenciyonetim.service.ISubjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;

  
    private Subject createSubject(DtoSubjectIU iu) {
        Subject subject = new Subject();
        subject.setCreateTime(new Date());
        BeanUtils.copyProperties(iu, subject);
        return subject;
    }

    @Override
    public List<DtoSubject> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<DtoSubject> dtoList = new ArrayList<>();
        for (Subject s : subjects) {
            DtoSubject dto = new DtoSubject();
            BeanUtils.copyProperties(s, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoSubject getSubjectById(Long id) {
        Optional<Subject> opt = subjectRepository.findById(id);
        DtoSubject dto = new DtoSubject();
        BeanUtils.copyProperties(opt.get(), dto);
        return dto;
    }

    @Override
    public DtoSubject saveSubject(DtoSubjectIU iu) {
        Subject saved = subjectRepository.save(createSubject(iu));
        DtoSubject dto = new DtoSubject();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    public DtoSubject updateSubject(Long id, DtoSubjectIU iu) {
        Optional<Subject> opt = subjectRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }
        Subject subject = opt.get();
        BeanUtils.copyProperties(iu, subject);
        Subject saved = subjectRepository.save(subject);
        DtoSubject dto = new DtoSubject();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    public void deleteSubject(Long id) {
    	subjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Subject not found: " + id));
    	
        subjectRepository.deleteById(id);
    }
}
