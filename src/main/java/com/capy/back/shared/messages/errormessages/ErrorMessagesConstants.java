package com.capy.back.shared.messages.errormessages;

public class ErrorMessagesConstants {
    public static final String USER_NULL= "El usuario no puede ser nulo";
    public static final String USERS_NOT_FOUND = "No se encontraron usuarios";

    private ErrorMessagesConstants() {
        throw new IllegalStateException("Utility class");
    }
}
