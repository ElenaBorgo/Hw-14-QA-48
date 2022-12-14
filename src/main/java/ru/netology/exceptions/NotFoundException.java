package ru.netology.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товар с данным ID не найден: " + id);
    }
}
