package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
@PageTitle("Wishlist | PCari")
public class WishlistView extends ViewFrame {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        /*if (!MainView.accessControl.isUserSignedIn()) {
            MainView.get().launchLogin();
        }
*/
        MainView.get().appFooterInner.setVisible(true);

        setViewContent(createView());
    }

    private Component createView() {
        VerticalLayout vl = new VerticalLayout();
        Image img = new Image("images/logo.png", "Logo");
        img.setHeight("40px");
        img.getStyle().set("align-self", "center");


        Label label = new Label("0 Wishlist(s)");
        label.getStyle().set("font-size", "18px");
        label.getStyle().set("font-weight", "bold");
        label.getStyle().set("align-self", "center");


        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(false);
        hl.getStyle().set("align-self", "stretch");
        Image icon = new Image("icons/user.png", "User image");
        icon.setHeight("100px");
        icon.getStyle().set("opacity", "0.75");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setSpacing(false);
        Label name = new Label("Users Name");
        name.getStyle().set("font-size", "13px");
        name.getStyle().set("font-weight", "bold");

        Label join = new Label("Joined 4 days ago");
        join.getStyle().set("font-size", "10px");

        infoLayout.add(name, join);
        infoLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);


        hl.add(icon);
        hl.addAndExpand(infoLayout);
        vl.add(img, hl, label);
        return vl;
    }
}
