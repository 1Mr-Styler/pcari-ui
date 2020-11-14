package com.lyshnia.pcari.search;

import com.lyshnia.pcari.DashboardView;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = SearchView.VIEW_NAME, layout = MainView.class)
@PageTitle("Search | PCari")
public class SearchView extends ViewFrame implements HasUrlParameter<String> {

    public static final String VIEW_NAME = "search";

    private boolean redirect = false;
    private Category category;

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        MainView.get().appFooterInner.setVisible(false);

        if (redirect)
            UI.getCurrent().navigate(DashboardView.class);


        if (category == Category.Services)
            setViewContent(new ServiceLayout());
        else setViewContent(new SearchLayout(category));

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String cat) {
        try {
            category = Category.valueOf(cat);
        } catch (Exception ignored) {
            redirect = true;
        }
    }
}
