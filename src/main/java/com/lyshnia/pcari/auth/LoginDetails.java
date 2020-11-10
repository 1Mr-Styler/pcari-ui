package com.lyshnia.pcari.auth;

import java.util.List;

public class LoginDetails {
    private String username;
    private List roles;
    private String token_type;
    private String access_token;
    private String refresh_token;
    private Long expires_in;

    public LoginDetails(String username, List roles, String token_type, String access_token, String refresh_token, Long expires_in) {
        this.username = username;
        this.roles = roles;
        this.token_type = token_type;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.expires_in = expires_in;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return getToken_type()
                + " " + access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                ", token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
