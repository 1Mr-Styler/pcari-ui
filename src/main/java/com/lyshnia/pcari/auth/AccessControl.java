package com.lyshnia.pcari.auth;

import com.lyshnia.pcari.user.User;

public interface AccessControl {
    boolean signIn(String username, String password);

    boolean isUserSignedIn();

    boolean isUserInRole(String role);

    String getPrincipalName();

    User getUserInfo();

    LoginDetails getLogin();

    void signOut();
}
