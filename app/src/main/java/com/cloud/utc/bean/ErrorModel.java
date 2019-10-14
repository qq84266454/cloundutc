package com.cloud.utc.bean;

import java.util.List;

public class ErrorModel{
    private int status_code;
    private String message;
    private ErrorBody errors;

    public ErrorModel() {
    }

    public ErrorModel(int status_code, String message, ErrorBody errors) {
        this.status_code = status_code;
        this.message = message;
        this.errors = errors;
    }

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

    public ErrorBody getErrors() {
        return errors;
    }

    public void setErrors(ErrorBody errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "status_code=" + status_code +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }


    public  static class ErrorBody{
        List<String> account;
        List<String> password;

        public ErrorBody(List<String> account) {
            this.account = account;
        }

        @Override
        public String toString() {
            return "ErrorBody{" +
                    "account=" + account +
                    ", password=" + password +
                    '}';
        }

        public List<String> getAccount() {
            return account;
        }

        public void setAccount(List<String> account) {
            this.account = account;
        }

        public List<String> getPassword() {
            return password;
        }

        public void setPassword(List<String> password) {
            this.password = password;
        }
    }
}
