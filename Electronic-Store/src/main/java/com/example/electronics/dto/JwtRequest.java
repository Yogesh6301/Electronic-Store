package com.example.electronics.dto;

public class JwtRequest {

    private String email;
    private String password;

    // No-args constructor
    public JwtRequest() {
    }

    // All-args constructor
    public JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Builder
    public static JwtRequestBuilder builder() {
        return new JwtRequestBuilder();
    }

    public static class JwtRequestBuilder {
        private String email;
        private String password;

        public JwtRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public JwtRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public JwtRequest build() {
            return new JwtRequest(email, password);
        }
    }
}
