package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

import static com.lyshnia.pcari.MainView.accessControl;

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

        PrettyTime p = new PrettyTime();
        getModel().setN(p.format(Date.from(accessControl.getUserInfo().getDateLD().atStartOfDay(MainView.ZONE_ID).toInstant())));
        getModel().setNames(accessControl.getUserInfo().getNames());
        getModel().setEmail(accessControl.getUserInfo().getUsername());

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

        void setNames(String names);

        void setEmail(String email);
    }
}
