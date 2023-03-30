package ru.edu.springliquibase.exception;

public class NotFoundException extends RuntimeException {

    public <T, E> NotFoundException(T id, Class<E> eClass) {
        super("Not found entity %s with identity %s".formatted(id.toString(), eClass.getSimpleName()));
    }

}
