<<<<<<< HEAD
package com.ogrenciyonetim.repository;

import com.ogrenciyonetim.model.Grade;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Long> {
	
	List<Grade> findByStudentId(Long studentId);
	
	
	@Modifying
    @Transactional
    @Query("DELETE FROM Grade g WHERE g.student.id = :studentId")
    void deleteByStudentId(@Param("studentId") Long studentId);
}
=======
package com.ogrenciyonetim.repository;

import com.ogrenciyonetim.model.Grade;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Long> {
	
	List<Grade> findByStudentId(Long studentId);
	
	
	@Modifying
    @Transactional
    @Query("DELETE FROM Grade g WHERE g.student.id = :studentId")
    void deleteByStudentId(@Param("studentId") Long studentId);
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
