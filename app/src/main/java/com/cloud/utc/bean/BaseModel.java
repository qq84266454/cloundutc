package com.cloud.utc.bean;

import java.util.List;

public class BaseModel<T> {

    @Override
    public String toString() {
        return "BaseModel{" +
                "status_code=" + status_code +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                ", data=" + data +
                '}';
    }

    /**
     * status_code : 200
     * message : success
     * errors : []
     */

    private int status_code;
    private String message;
    private List<?> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getErrors() {
        return errors;
    }

    public void setErrors(List<?> errors) {
        this.errors = errors;
    }
}
