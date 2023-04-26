package ru.edu.ycode.exception;

import java.util.List;

public class NotFoundException extends RuntimeException {

    public <T, E> NotFoundException(T id, Class<E> eClass) {
        super("Not found entity %s with identity %s".formatted(eClass.getSimpleName(), id.toString()));
    }

    public <T, E> NotFoundException(List<T> id, Class<E> eClass) {
        super("Not found entity %s with identities %s".formatted(eClass.getSimpleName(), id.toString()));
    }
}
