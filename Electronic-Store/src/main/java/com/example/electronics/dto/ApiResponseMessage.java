package com.example.electronics.dto;

import org.springframework.http.HttpStatus;

public class ApiResponseMessage {

    private String message;
    private boolean success;
    private HttpStatus status;

    // No-args constructor
    public ApiResponseMessage() {
    }

    // All-args constructor
    public ApiResponseMessage(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    // Builder pattern
    public static class Builder {
        private String message;
        private boolean success;
        private HttpStatus status;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponseMessage build() {
            return new ApiResponseMessage(message, success, status);
        }
    }

    // toString
    @Override
    public String toString() {
        return "ApiResponseMessage{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", status=" + status +
                '}';
    }

	
}
