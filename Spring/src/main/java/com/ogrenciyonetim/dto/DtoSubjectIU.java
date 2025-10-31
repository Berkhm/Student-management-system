<<<<<<< HEAD
package com.ogrenciyonetim.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;


import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoSubjectIU {

    @NotEmpty
    private String subjectName;

    @NotEmpty
    private String subjectType;

    @NotEmpty
    private String day;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String finishTime;

    @NotNull
    private Integer classNo;

    @NotNull
    private Integer credit;

}
=======
package com.ogrenciyonetim.dto;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;


import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoSubjectIU {

    @NotEmpty
    private String subjectName;

    @NotEmpty
    private String subjectType;

    @NotEmpty
    private String day;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String finishTime;

    @NotNull
    private Integer classNo;

    @NotNull
    private Integer credit;

}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
