package Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerLoginFormDTO {

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

}
