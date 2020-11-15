package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.auth.AccessControl;
import com.lyshnia.pcari.auth.BasicAccessControl;
import retrofit2.Response;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static com.lyshnia.pcari.MainView.accessControl;

public class User {
    @NotNull
    private Long id;
    @NotNull
    private String username;
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
    @NotNull
    private String names;
    @NotNull
    private String date;
    @NotNull
    private Role role;
    private String avatar;
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean passwordExpired;

    public User(HashMap<String, Long> hashMap) {
        User loadedUser = User.make(hashMap.get("id"));
        if (loadedUser == null)
            return;

        this.id = loadedUser.id;
        this.username = loadedUser.username;
        this.password = loadedUser.password;
        this.names = loadedUser.names;
        this.role = loadedUser.role;
        this.avatar = loadedUser.avatar;
        this.enabled = loadedUser.enabled;
        this.accountExpired = loadedUser.accountExpired;
        this.accountLocked = loadedUser.accountLocked;
        this.passwordExpired = loadedUser.passwordExpired;
    }

    public User() {
    }

    public User(String username, String password, String names, String phone, String email, String avatar, Role role, boolean enabled, boolean accountExpired, boolean accountLocked, boolean passwordExpired) {
        this.username = username;
        this.password = password;
        this.names = names;
        this.role = role;
        this.avatar = avatar;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.passwordExpired = passwordExpired;
    }

    public User(Long id, String username, String password, String names, String email, Role role, boolean enabled, boolean accountExpired, boolean accountLocked, boolean passwordExpired) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.names = names;
        this.role = role;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.passwordExpired = passwordExpired;
    }

    // Load from ID
    public static User make(Long id) {
        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {

            UserService service = MainView.retrofit.create(UserService.class);

            try {
                Response<User> response = service.get(accessControl.getLogin().getAccess_token(), id).execute();
                System.out.println(response.raw());

                if (response.isSuccessful()) {

                    User user = response.body();
                    return user;
                }
                System.out.println(response.code());

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        System.out.println("isUserSignedIn: " + accessControl.isUserSignedIn());
        return null;
    }

    // Load from Username
    public static User make(String username) {
        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {

            UserService userService = MainView.retrofit.create(UserService.class);

            try {
                Response<User> response = userService.getDetails(accessControl.getLogin().getAccess_token(),
                        MainView.processPhone(username)).execute();
                System.out.println(response.raw());

                if (response.isSuccessful()) {
                    return response.body();
                }
                System.out.println(response.code());

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        System.out.println("isUserSignedIn: " + accessControl.isUserSignedIn());
        return null;
    }

    // Create
    public static User make(String username, String names, String email) {
        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {

            UserService userService = MainView.retrofit.create(UserService.class);

            try {
                HashMap<String, Object> data = new HashMap<>();
                data.put("username", MainView.processPhone(username));
                data.put("email", email);
                data.put("password", "password");
                data.put("names", names);
                data.put("role", Role.Customer);

                Response<User> response = userService.save(accessControl.getLogin().getAccess_token(), data, null).execute();
                System.out.println(response.raw());

                if (response.isSuccessful()) {
                    return response.body();
                }
                System.out.println(response.code());

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        System.out.println("isUserSignedIn: " + accessControl.isUserSignedIn());
        return null;
    }

    public static Collection<User> findAll() {
        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {
            UserService service = MainView.retrofit.create(UserService.class);

            try {
                Response<Collection<User>> response = service.findAll(accessControl.getLogin().getAccess_token()).execute();
                System.out.println(response.raw());

                if (response.isSuccessful()) {
                    return response.body();
                }
                System.out.println(response.code());

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        return Collections.emptyList();
    }

    public boolean save() {
        if (this.getId() != null)
            return update();

        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {
            UserService service = MainView.retrofit.create(UserService.class);

            try {
                HashMap<String, Object> body = new HashMap<>();
                body.put("names", this.getNames());
                body.put("username", this.getUsername());
                body.put("password", this.getPassword());
                body.put("role", this.getRole().toString());

                Long branchId = null;

                System.out.println(body);
                Response<User> userResponse = service.save(accessControl.getLogin().getAccess_token(), body, branchId).execute();
                System.out.println(userResponse);

                if (userResponse.isSuccessful()) {
                    this.setId(userResponse.body().id);
                    return true;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return false;
    }

    public boolean update() {

        AccessControl accessControl = new BasicAccessControl();

        if (accessControl.isUserSignedIn()) {

            UserService service = MainView.retrofit.create(UserService.class);

            try {
                HashMap<String, Object> body = new HashMap<>();
                body.put("names", this.getNames());
//                body.put("username", this.getUsername());
                body.put("password", this.getPassword());
//                body.put("branch", this.getMixture());
//                body.put("role", this.getRole().toString());

                System.out.println(body);
                Response<User> userResponse = service.update(accessControl.getLogin().getAccess_token(), this.getId(), body).execute();
                System.out.println(userResponse);

                if (userResponse.isSuccessful()) {
                    return true;
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        if (names == null)
            fill();
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getAvatar() {
        return avatar == null ? "ar0ef4o4lclcowez7fni" : avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getNames() + " (" + username + ")";
    }

    public void fill() {
        if (id != null) {
            User user = User.make(this.id);

            this.setNames(user.getNames());
            this.setUsername(user.getUsername());
            this.setDate(user.getDate());
        }
    }

/*
    public Customer getCustomer() {
        UserService service = MainView.retrofit.create(UserService.class);
        try {
            Response<Customer> customerResponse = service.getCustomer(accessControl.getLogin().getAccess_token(), this.getId()).execute();
            System.out.println("customerResponse = " + customerResponse.raw());
            return customerResponse.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public boolean isAdmin() {
        return accessControl.isUserInRole("ROLE_ADMIN");
    }

    public boolean isIT() {
        return this.getRole() == Role.IT;
    }

    public boolean isManager() {
        return this.getRole() == Role.Manager;
    }

    public boolean isStaff() {
        return this.getRole() == Role.Staff;
    }

    public boolean isCashier() {
        return this.getRole() == Role.Cashier;
    }

    public boolean isCLevel() {
        return this.getRole() == Role.CLevel;
    }

    public boolean isAccountant() {
        return this.getRole() == Role.Accountant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDate getDateLD() {
        fill();
        return date == null ? null : LocalDate.parse(date);
    }

}
