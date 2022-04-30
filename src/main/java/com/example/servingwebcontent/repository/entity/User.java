package com.example.servingwebcontent.repository.entity;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Min(value = 0, message = "Id shouldn't be less than 0")
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30")
    private String name;

    private Sex sex;

    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Enter valid email")
    private String email;
}
