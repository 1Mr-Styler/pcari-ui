package com.lyshnia.pcari.app;

import com.github.appreciated.card.ClickableCard;
import com.lyshnia.pcari.DashboardView;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the home-screen template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("home-screen")
@JsModule("./views/home-screen.js")
public class HomeScreen extends PolymerTemplate<HomeScreen.HomeScreenModel> {

    @Id("cardLayout")
    private VerticalLayout cardLayout;
    @Id("getStarted")
    private Button getStarted;

    /**
     * Creates a new HomeScreen.
     */
    public HomeScreen() {
        // You can initialise any data required for the connected UI components here.

        ClickableCard card1 = new ClickableCard();
        card1.setWidthFull();
        card1.setHeight("200px");
        card1.getChildren().findFirst().get().getElement().getStyle().set("background-color", "white");
        card1.add(new Html("<iframe width=\"100%\"  height=\"200\" src=\"https://www.youtube.com/embed/6Z4DAzC8Lfk\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));


        ClickableCard card2 = new ClickableCard();
        card2.setWidthFull();
        card2.setHeight("180px");
        card2.getChildren().findFirst().get().getElement().getStyle().set("background-color", "white");

        cardLayout.add(card1);

        getStarted.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(DashboardView.class));
    }

    /**
     * This model binds properties between HomeScreen and home-screen
     */
    public interface HomeScreenModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
