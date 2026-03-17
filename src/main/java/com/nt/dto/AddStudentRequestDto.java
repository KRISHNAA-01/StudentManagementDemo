package com.nt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStudentRequestDto {

    @NotBlank(message = "name shouldn't be blank")
    private String name;

    @Email
    @NotBlank(message = "email is required")
    private String email;
}
