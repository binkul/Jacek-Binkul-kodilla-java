package com.kodilla.hibernate.manytomany.facade;

public class EntityNotFoundException extends Exception {
    public static final String NOT_FOUND_COMPANY = "No company with the given shortcut was found.";
    public static final String NOT_FOUND_EMPLOYEE = "No employee with the the given shortcut was found.";

    public EntityNotFoundException(String message) {
        super(message);
    }
}
