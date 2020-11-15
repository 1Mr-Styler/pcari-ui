package com.lyshnia.pcari.auth;

import com.lyshnia.pcari.DashboardView;
import com.lyshnia.pcari.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the login-layout template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-layout")
@JsModule("./views/login-layout.js")
public class LoginLayout extends PolymerTemplate<LoginLayout.LoginLayoutModel> {

    private Dialog dialog;
    @Id("closeButton")
    private Button closeButton;
    @Id("loginForm")
    private LoginForm loginForm;
    @Id("holder2")
    private VerticalLayout holder2;
    @Id("registerButton")
    private Button registerButton;
    @Id("registerForm")
    private Element registerForm;
    @Id("infoSpan")
    private Span infoSpan;
    @Id("regSubmitButton")
    private Button regSubmitButton;

    /**
     * Creates a new LoginLayout.
     */
    public LoginLayout(Dialog dialog) {
        // You can initialise any data required for the connected UI components here.
        this.dialog = dialog;
        registerForm.setVisible(false);

        closeButton.addClickListener(buttonClickEvent -> {
            if (!MainView.accessControl.isUserSignedIn())
                UI.getCurrent().navigate(DashboardView.class);
            dialog.close();
        });

        loginForm.addLoginListener(this::login);
        loginForm.addForgotPasswordListener(
                event -> Notification.show("Hint: same as username"));

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.getForm().setUsername("Email");

        loginForm.setI18n(i18n);

        registerButton.addClickListener(buttonClickEvent -> {
//            holder2.replace(loginForm, new Span("Meiw"));
            loginForm.setVisible(!loginForm.isVisible());
            registerForm.setVisible(!registerForm.isVisible());

            if (loginForm.isVisible()) {
                infoSpan.setText("Don't have an account?");
                registerButton.setText("Register here");
            } else {
                infoSpan.setText("Already have an account?");
                registerButton.setText("Sign in here");
            }
        });
    }

    private void login(LoginForm.LoginEvent event) {
        if (MainView.accessControl.signIn(event.getUsername(), event.getPassword())) {
            dialog.close();
            UI.getCurrent().getPage().reload();
        } else {
            event.getSource().setError(true);
        }

    }

    /**
     * This model binds properties between LoginLayout and login-layout
     */
    public interface LoginLayoutModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
