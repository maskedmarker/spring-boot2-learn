package org.example.learn.spring.boot.commons.model.user.po;

import org.example.learn.spring.boot.commons.model.base.BasePO;

public class UserPO extends BasePO {

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
