package org.example.learn.spring.boot.commons.model.user.dto;

import org.example.learn.spring.boot.commons.model.base.BaseDTO;

public class UserDTO extends BaseDTO {

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
