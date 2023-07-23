package com.geekster.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer userId;
    @NotEmpty
    private String userName;
    @Email
    private  String userEmail;

    //rules for password regex
    //at least one special character //start with capital english letter //at least 6 character long//should have at least one numeric digit
    @Pattern(regexp = "^(?=.*[!@#$%^&*()\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d)(?=.*[A-Z]).{6,}$")
    private String password;

    @Pattern(regexp = "^(\\+[1-9]\\d{0,2})?\\d{10}$")
    private String userContact;

    @Min(value = 18)
    @Max(value=35)
    private Integer userAge;

    //@Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])$")
    private LocalDate userDOB; //2023-12-05

    private Type userType;
}
