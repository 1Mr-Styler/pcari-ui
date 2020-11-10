package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.auth.AccessControlFactory;
import com.lyshnia.pcari.auth.LoginView;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Logout", layout = MainView.class)
public class Logout extends VerticalLayout {
    public static final String VIEW_NAME = "Logout";

    public Logout() {
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        AccessControlFactory
                .getInstance().createAccessControl().signOut();

        getUI().ifPresent(ui ->
                ui.navigate(LoginView.class));
    }
}
