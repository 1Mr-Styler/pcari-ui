package com.lyshnia.pcari.auth;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Lyshnia POS | Login")
public class LoginView extends FlexLayout {
    private AccessControl accessControl;

    public LoginView() {

        setSizeFull();
        accessControl = AccessControlFactory.getInstance().createAccessControl();

        // login form, centered in the available part of the screen
        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(this::login);
        loginForm.addForgotPasswordListener(
                event -> Notification.show("Hint: same as username"));

        // layout to center login form when there is sufficient screen space
        FlexLayout centeringLayout = new FlexLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);

        centeringLayout.add(loginForm);

        Image image = new Image("images/logo.png", "logo");
        image.setWidth("300px");


        centeringLayout.getStyle().set("flex-direction", "column-reverse");
        getStyle().set("flex-direction", "column");
        centeringLayout.add(image);
        add(centeringLayout);
    }

    private void login(LoginForm.LoginEvent event) {
        if (accessControl.signIn(event.getUsername(), event.getPassword())) {
            getUI().get().navigate("");
        } else {
            event.getSource().setError(true);
        }


    }
}
