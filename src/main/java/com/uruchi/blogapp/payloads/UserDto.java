package com.uruchi.blogapp.payloads;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotNull
    @Size(min = 4, message = "Name should have at least 4 characters")
    private String name;
    @Email(message = "Email should be valid")
    @NotNull
    private String email;
    //@NotEmpty
    //@Size(min = 6,max = 15, message = "Password should have at least 15 characters")
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password should have at least one digit, one lower case, one upper case, one special character and no white spaces"
    //private String password;


}
