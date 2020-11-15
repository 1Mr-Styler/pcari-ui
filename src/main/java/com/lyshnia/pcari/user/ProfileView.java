package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the profile-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("profile-view")
@JsModule("./views/profile-view.js")
public class ProfileView extends PolymerTemplate<ProfileView.ProfileViewModel> {

    @Id("closeButton")
    private Button closeButton;
    @Id("logoutButton")
    private Button logoutButton;

    /**
     * Creates a new ProfileView.
     */
    public ProfileView(Dialog dialog) {
        // You can initialise any data required for the connected UI components here.
        closeButton.addClickListener(buttonClickEvent -> dialog.close());

        getModel().setN("4 days ago");

        logoutButton.addClickListener(buttonClickEvent -> {
            MainView.accessControl.signOut();
        });
    }

    /**
     * This model binds properties between ProfileView and profile-view
     */
    public interface ProfileViewModel extends TemplateModel {
        // Add setters and getters for template properties here.

        void setN(String n);
    }
}
