<<<<<<< HEAD
package com.ogrenciyonetim.dto;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoStudentIU {

	    @NotEmpty
	    private String name;

	    @NotEmpty
	    private String mail;

	    @NotEmpty
	    private String faculty;

	    @NotEmpty
	    private String telNo;

	    @NotEmpty
	    private String address;

	    @NotNull
	    private Long advisorId;

	    @NotEmpty
	    private String studentNo;

	    @NotNull
	    private Integer gradeYear;

	    @NotNull
	    private Double gpa;

	    @NotEmpty
	    private String department;

	    @NotNull
	    private Integer discontinuityDays;
}


=======
package com.ogrenciyonetim.dto;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoStudentIU {

	    @NotEmpty
	    private String name;

	    @NotEmpty
	    private String mail;

	    @NotEmpty
	    private String faculty;

	    @NotEmpty
	    private String telNo;

	    @NotEmpty
	    private String address;

	    @NotNull
	    private Long advisorId;

	    @NotEmpty
	    private String studentNo;

	    @NotNull
	    private Integer gradeYear;

	    @NotNull
	    private Double gpa;

	    @NotEmpty
	    private String department;

	    @NotNull
	    private Integer discontinuityDays;
}


>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
