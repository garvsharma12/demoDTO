package com.javaDTO.demoDTO.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequestDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @NotBlank(message = "Branch is mandatory")
    private String branch;
    @Email(message = "Email should be valid")
    private String email;

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
