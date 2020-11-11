package com.lyshnia.pcari;

import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
@PageTitle("Dashboard | PCari")
public class DashboardView extends ViewFrame {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        setViewContent(new com.lyshnia.pcari.app.DashboardView());
    }
}
