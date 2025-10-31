<<<<<<< HEAD
package com.ogrenciyonetim.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoGradeIU {
	
	@NotNull
    private Long studentId;
	
	@NotEmpty
	private String subjectName;

    @NotNull
    private Double midterm;

    @NotNull
    private Double finalExam;

    @NotNull
    private Double average;

    @NotEmpty
    private String letterGrade;

}
=======
package com.ogrenciyonetim.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoGradeIU {
	
	@NotNull
    private Long studentId;
	
	@NotEmpty
	private String subjectName;

    @NotNull
    private Double midterm;

    @NotNull
    private Double finalExam;

    @NotNull
    private Double average;

    @NotEmpty
    private String letterGrade;

}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
