package com.example.electronics.dto;

public class JwtResponse {

    private String jwtToken;
    private UserDto user;

    // No-args constructor
    public JwtResponse() {
    }

    // All-args constructor
    public JwtResponse(String jwtToken, UserDto user) {
        this.jwtToken = jwtToken;
        this.user = user;
    }

    // Getters
    public String getJwtToken() {
        return jwtToken;
    }

    public UserDto getUser() {
        return user;
    }

    // Setters
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    // Builder
    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private UserDto user;

        public JwtResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder user(UserDto user) {
            this.user = user;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, user);
        }
    }
}
