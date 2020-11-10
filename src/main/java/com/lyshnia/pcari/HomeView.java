package com.lyshnia.pcari;

import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends ViewFrame {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        setViewContent();
    }
}