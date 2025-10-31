<<<<<<< HEAD
package com.ogrenciyonetim.dto;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;


import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoTeacherIU {
	

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

    @NotEmpty
    private String title;

    @NotEmpty
    private String major;
}
=======
package com.ogrenciyonetim.dto;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;


import org.antlr.v4.runtime.misc.NotNull;

@Data
public class DtoTeacherIU {
	

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

    @NotEmpty
    private String title;

    @NotEmpty
    private String major;
}
>>>>>>> 05ba1d4e70f94beab4585166793e3ba52ce2e370
