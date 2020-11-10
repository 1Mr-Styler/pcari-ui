package com.lyshnia.pcari.user;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.auth.AccessControl;
import com.lyshnia.pcari.auth.BasicAccessControl;
import com.lyshnia.pcari.aux.FileUploader;
import com.lyshnia.pcari.ui.FlexBoxLayout;
import com.lyshnia.pcari.ui.ListItem;
import com.lyshnia.pcari.ui.size.Bottom;
import com.lyshnia.pcari.ui.size.Horizontal;
import com.lyshnia.pcari.ui.size.Vertical;
import com.lyshnia.pcari.ui.util.BoxShadowBorders;
import com.lyshnia.pcari.ui.util.LumoStyles;
import com.lyshnia.pcari.ui.util.UIUtils;
import com.lyshnia.pcari.ui.util.css.BorderRadius;
import com.lyshnia.pcari.ui.util.css.FlexDirection;
import com.lyshnia.pcari.ui.util.css.FlexWrap;
import com.lyshnia.pcari.ui.util.css.WhiteSpace;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Route(layout = MainView.class)
@PageTitle("My Profile")
public class ProfileView extends VerticalLayout {

    AccessControl accessControl = new BasicAccessControl();
    FileUploader buffer = new FileUploader();
    Upload upload = new Upload(buffer);
    Cloudinary cloudinary = new
            Cloudinary(ObjectUtils.asMap(
            "cloud_name", "lyshnia-limited",
            "api_key", "739118628765371",
            "api_secret", "8ox179PXwdYqX4C07Zchct0A2l0"));
    User user;

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        user = accessControl.getUserInfo();

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout();
        Button uaButton = new Button("Update Picture");
        Button cpButton = new Button("Change Password");

        hl.add(uaButton, cpButton);
        hl.setWidthFull();
        verticalLayout.setSizeFull();

        FlexBoxLayout content = new FlexBoxLayout(
                createLogoSection(), hl, verticalLayout
        );
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO, Vertical.RESPONSIVE_L);
        content.setMaxWidth("840px");
        add(content);

        cpButton.addClickListener(event -> {
            verticalLayout.removeAll();
            verticalLayout.add(changePassword());
        });
        uaButton.addClickListener(event -> {
            verticalLayout.removeAll();
            verticalLayout.add(changeAvi());
        });
    }

    private FlexBoxLayout createLogoSection() {
        String src = cloudinary.url().publicId(user.getAvatar()).transformation(
                new Transformation()
                        .width(200)
                        .height(200)
                        .crop("thumb")
                        .gravity("face")).secure(true).generate();

        Image image = new Image(src, user.getNames());
        image.addClassName(LumoStyles.Margin.Horizontal.L);
        UIUtils.setBorderRadius(BorderRadius._50, image);
        image.setHeight("200px");
        image.setWidth("200px");

        ListItem availability;
        ListItem bankAccount;
        ListItem updated;

        availability = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.NEWSPAPER), user.getNames(), "Name");
        availability.getPrimary().addClassName(LumoStyles.Heading.H2);
        availability.setDividerVisible(true);
        availability.setId("availability");
        availability.setReverse(true);

        bankAccount = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.INSTITUTION), user.getUsername(), "Phone");
        bankAccount.setDividerVisible(true);
        bankAccount.setId("bankAccount");
        bankAccount.setReverse(true);
        bankAccount.setWhiteSpace(WhiteSpace.PRE_LINE);

        updated = new ListItem(UIUtils.createTertiaryIcon(VaadinIcon.CALENDAR), user.getEmail(), "Email");
        updated.setReverse(true);

        FlexBoxLayout listItems = new FlexBoxLayout(availability, bankAccount, updated);
        listItems.setFlexDirection(FlexDirection.COLUMN);

        FlexBoxLayout section = new FlexBoxLayout(image, listItems);
        section.addClassName(BoxShadowBorders.BOTTOM);
        section.setAlignItems(Alignment.CENTER);
        section.setFlex("1", listItems);
        section.setFlexWrap(FlexWrap.WRAP);
        section.setJustifyContentMode(JustifyContentMode.CENTER);
        section.setPadding(Bottom.L);
        return section;
    }

    private VerticalLayout changePassword() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMaxWidth("400px");

        H3 label = new H3("Change Password");
        verticalLayout.add(label);

        FormLayout formLayout = new FormLayout();
        PasswordField newPassword = new PasswordField();
        PasswordField cfmPassword = new PasswordField();
        Button save = new Button("Update");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        formLayout.addFormItem(newPassword, "New Password");
        formLayout.addFormItem(cfmPassword, "Confirm Password");
        formLayout.add(save);

        save.addClickListener(event -> {
            if (!newPassword.getValue().equals(cfmPassword.getValue())) {
                label.setText("Password mismatch");
                label.getStyle().set("color", "red");
                return;
            }

            user.setPassword(newPassword.getValue());
            if (user.save()) {
                label.setText("Password updated!");
                label.getStyle().set("color", "green");
            } else {
                label.setText("An error occurred. ");
                label.getStyle().set("color", "red");
            }
        });


        verticalLayout.add(formLayout);
        return verticalLayout;
    }

    private VerticalLayout changeAvi() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMaxWidth("400px");

        H3 label = new H3("Change Avatar");
        verticalLayout.add(label);

        upload.setDropLabel(new Label("New Picture"));
        upload.setAcceptedFileTypes("image/jpeg", "image/png");
        upload.addSucceededListener(event -> {
            try {
                File file = new File(buffer.getFilename());
                Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
                user.setAvatar((String) uploadResult.get("public_id"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Button save = new Button("Update");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        verticalLayout.add(upload, save);

        save.addClickListener(event -> {
            if (user.getAvatar() == "ar0ef4o4lclcowez7fni") {
                label.setText("Please upload an image");
                label.getStyle().set("color", "red");
                return;
            }

            if (user.save()) {
                label.setText("Avatar updated!");
                label.getStyle().set("color", "green");
            } else {
                label.setText("An error occurred. ");
                label.getStyle().set("color", "red");
            }
        });


        return verticalLayout;
    }
}
