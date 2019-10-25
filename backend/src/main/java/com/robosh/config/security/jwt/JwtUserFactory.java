package com.robosh.config.security.jwt;

import com.robosh.data.entity.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getPassword(),
                user.getLogin(),
                user.getRole()
        );
    }
}
