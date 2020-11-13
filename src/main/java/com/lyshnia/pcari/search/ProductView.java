package com.lyshnia.pcari.search;

import com.lyshnia.pcari.DashboardView;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.ViewFrame;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.*;

import java.util.List;
import java.util.Map;

@Route(value = ProductView.VIEW_NAME, layout = MainView.class)
@PageTitle("Product | PCari")
public class ProductView extends ViewFrame implements HasUrlParameter<String> {

    public static final String VIEW_NAME = "product";

    private boolean redirect = false;
    private Long id;
    private String category;

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        MainView.get().appFooterInner.setVisible(false);

        if (redirect)
            UI.getCurrent().navigate(DashboardView.class);


        setViewContent(new ProductLayout(id, category));
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String parameters) {
        try {
//            this.id = id;
            Location location = beforeEvent.getLocation();
            QueryParameters queryParameters = location
                    .getQueryParameters();

            Map<String, List<String>> parametersMap =
                    queryParameters.getParameters();

            if (!(parametersMap.containsKey("category")) ||
                    parametersMap.get("category").isEmpty() ||
                    !parametersMap.containsKey("id") ||
                    parametersMap.get("id").isEmpty()) {
                UI.getCurrent().navigate(DashboardView.class);
                return;
            }


            this.id = Long.parseLong(parametersMap.get("id").get(0));
            this.category = parametersMap.get("category").get(0);

        } catch (Exception ignored) {
            redirect = true;
        }
    }
}
