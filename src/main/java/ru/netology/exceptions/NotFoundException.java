package ru.netology.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String e) {
        super(e);
    }
}
