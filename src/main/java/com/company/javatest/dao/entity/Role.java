package com.company.javatest.dao.entity;

public enum Role {
    ROLE_USER, ROLE_ADMIN, ROLE_ANONYMOUS;

    Role() {}

    public String getName() {
        return name();
    }
}
