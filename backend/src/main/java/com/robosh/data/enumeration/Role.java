package com.robosh.data.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum  Role  implements GrantedAuthority {
    ADMIN, STUDENT, PARENT, TEACHER, DIRECTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
