package com.capy.back.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {
    public String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
