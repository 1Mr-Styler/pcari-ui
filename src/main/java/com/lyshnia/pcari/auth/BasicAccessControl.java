package com.lyshnia.pcari.auth;

import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.user.User;
import com.lyshnia.pcari.user.UserService;
import com.vaadin.flow.server.VaadinSession;
import retrofit2.Response;

import java.util.HashMap;

public class BasicAccessControl implements AccessControl {
    @Override
    public boolean signIn(String username, String password) {
        if (username == null || username.isEmpty())
            return false;

        Login service = MainView.retrofit.create(Login.class);

        HashMap<String, String> data = new HashMap<String, String>();
        if (username.startsWith("0"))
            username = MainView.processPhone(username);

        data.put("username", username);
        data.put("password", password);
        try {
            Response<LoginDetails> loginDetails = service.login(data).execute();
            if (loginDetails.isSuccessful()) {
                if (loginDetails.body().getRoles().contains("ROLE_USER")) {
//                    UI.getCurrent().getPage().executeJavaScript("window.location.replace('http://localhost:8046');");
                    return false;
                }
                // Get user details
                UserService userService = MainView.retrofit.create(UserService.class);
                System.out.println("Login is successful");

                Response<User> userResponse = userService.getDetails(loginDetails.body().getAccess_token(), username).execute();
                User user = userResponse.body();
                CurrentUser.set(loginDetails.body(), user);

                /*System.out.println("user.getType() = " + user.getRole());
                Response<Employee> merchantResponse = userService.getEmployee(loginDetails.body().getAccess_token(), user.getId()).execute();
                user.setEmployee(merchantResponse.body());
                System.out.println("employee.body() = " + user.getEmployee());*/

                System.out.print("Data: ");
                System.out.println(userResponse);

                System.out.println(user);

                CurrentUser.set(loginDetails.body(), user);
            }
            System.out.println(loginDetails.body().toString());
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean isUserSignedIn() {
        return !(CurrentUser.get() == null);
    }

    @Override
    public boolean isUserInRole(String role) {
        return getLogin().getRoles().contains(role);
    }

    @Override
    public String getPrincipalName() {
        return CurrentUser.get().getUsername();
    }

    @Override
    public User getUserInfo() {
        return CurrentUser.get();
    }

    @Override
    public LoginDetails getLogin() {
        return CurrentUser.getLogin();
    }

    @Override
    public void signOut() {
        VaadinSession.getCurrent().getSession().invalidate();
    }
}
