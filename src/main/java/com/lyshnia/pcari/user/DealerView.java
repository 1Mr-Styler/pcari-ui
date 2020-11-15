package com.lyshnia.pcari.user;

import com.lyshnia.pcari.DashboardView;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = DealerView.VIEW_NAME, layout = MainView.class)
@PageTitle("Dealer | PCari")
public class DealerView extends ViewFrame implements HasUrlParameter<String> {

    public static final String VIEW_NAME = "dealer";

    private boolean redirect = false;
    private User dealer;

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        MainView.get().appFooterInner.setVisible(false);

        if (redirect)
            UI.getCurrent().navigate(DashboardView.class);


        setViewContent(new DealerProfile(dealer, dealer.getAvatar(), dealer.getLocation()));
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String cat) {
        try {
            dealer = User.make(Long.parseLong(cat));
        } catch (Exception ignored) {
            redirect = true;
        }
    }
}
