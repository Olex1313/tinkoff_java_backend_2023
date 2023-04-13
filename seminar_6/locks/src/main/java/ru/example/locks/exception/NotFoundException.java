package ru.example.locks.exception;

public class NotFoundException extends RuntimeException {

    public <T, E> NotFoundException(T id, Class<E> eClass) {
        super("Not found entity %s with identity %s".formatted(eClass.getSimpleName(), id.toString()));
    }

}
