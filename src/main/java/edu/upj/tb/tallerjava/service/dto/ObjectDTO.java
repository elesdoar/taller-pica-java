package edu.upj.tb.tallerjava.service.dto;

import java.io.Serializable;

/**
 * DTO for a object response.
 *
 * @param <T>
 */
public class ObjectDTO<T> implements Serializable {
    private T value;

    public ObjectDTO() {}

    public ObjectDTO(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
