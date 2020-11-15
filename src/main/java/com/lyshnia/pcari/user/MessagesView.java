package com.lyshnia.pcari.user;

import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
@PageTitle("Messages | PCari")
public class MessagesView extends ViewFrame {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        /*if(!MainView.accessControl.isUserSignedIn()) {
            MainView.get().launchLogin();
        }*/

        MainView.get().appFooterInner.setVisible(true);
        MainView.get().getAppBar().setVisible(true);
        MainView.get().getAppBar().setTitle("Messages");
        MainView.get().getAppBar().getAvatar().setVisible(false);
        MainView.get().getAppBar().getContextIcon().setVisible(false);
        MainView.get().getAppBar().getMenuIcon().setVisible(false);

        setViewContent(createView());
    }

    private Component createView() {
        VerticalLayout vl = new VerticalLayout();
        TextField search = new TextField();
        search.setPlaceholder("Search");
        search.setPrefixComponent(VaadinIcon.SEARCH.create());
        search.getStyle().set("padding-left", "20px");
        search.getStyle().set("padding-right", "20px");
        search.getStyle().set("margin-left", "20px");
        search.getStyle().set("margin-right", "20px");
        search.getStyle().set("align-self", "stretch");


        Label label = new Label("You have 0 message(s)");
        label.getStyle().set("font-size", "10px");

        vl.add(search, label);
        return vl;
    }
}
