package com.lyshnia.pcari.search;

import com.github.appreciated.card.ClickableCard;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.util.UIUtils;
import com.lyshnia.pcari.ui.util.css.Shadow;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Designer generated component for the result-layout template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("result-layout")
@JsModule("./views/result-layout.js")
public class ResultLayout extends PolymerTemplate<ResultLayout.ResultLayoutModel> {

    private List<Button> buttonList = new ArrayList<>();
    private Category category;

    @Id("backButton")
    private Button backButton;
    @Id("filterLayout")
    private HorizontalLayout filterLayout;
    @Id("reconButton")
    private Button reconButton;
    @Id("usedButton")
    private Button usedButton;
    @Id("newButton")
    private Button newButton;
    @Id("allButton")
    private Button allButton;
    @Id("resultHolder")
    private VerticalLayout resultHolder;

    /**
     * Creates a new ResultLayout.
     */
    public ResultLayout(Category category) {
        // You can initialise any data required for the connected UI components here.
        backButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(SearchView.VIEW_NAME + "/" + category.name()));
        this.category = category;

        getModel().setCat(category.name());

        if (category == Category.Services) {
            resultHolder.setVisible(false);
            filterLayout.setVisible(false);
        }

        buttonList.add(allButton);
        buttonList.add(newButton);
        buttonList.add(usedButton);
        buttonList.add(reconButton);

        resultHolder.add(createResult("BMW 523i 2.5 M Sport", "images/cooper.jpg", 2007, 35990, true));
        resultHolder.add(createResult("Mitsubishi asx 2.0 4wd facelift (at)", "images/asx.jpg", 2014, 57900, false));
        resultHolder.add(createResult("BMW 523i 2.5 M Sport", "images/cooper.jpg", 2007, 35990, false));
        resultHolder.add(createResult("Mitsubishi asx 2.0 4wd facelift (at)", "images/asx.jpg", 2014, 57900, false));

    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        allButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonList.forEach(button -> {
            UIUtils.setShadow(Shadow.S, button);

            button.addClickListener(buttonClickEvent -> {
                buttonList.forEach(button1 -> {
                    button1.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
                });
                buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            });

        });
    }

    private Component createResult(String name, String src, int year, int cost, boolean isFeatured) {
        name = name.toUpperCase();

        ClickableCard card = new ClickableCard();
        card.setWidthFull();
        card.setHeight("100px");


        /*Image image = new Image(src, name);
        image.setWidth("130px");
        image.setHeight("100px");*/

        Label flabel = new Label("FEATURED");
        flabel.getStyle().set("color", "white");
        flabel.getStyle().set("font-weight", "bold");
        flabel.getStyle().set("font-size", "10px");
        Icon ficon = VaadinIcon.TROPHY.create();
        ficon.setColor("white");
        ficon.setSize("10px");


        HorizontalLayout ftured = new HorizontalLayout(flabel, ficon);
        ftured.setSpacing(false);
        ftured.setAlignItems(FlexComponent.Alignment.CENTER);
        ftured.getStyle().set("padding-left", "7px");
        ftured.getStyle().set("background-color", "rgb(255, 175, 69)");
        ftured.setWidth("fit-content");
        ftured.setHeight("fit-content");


        VerticalLayout frstLayout = new VerticalLayout();
        frstLayout.setWidth("130px");
        frstLayout.setMinWidth("130px");
        frstLayout.setHeight("100px");
        frstLayout.getStyle().set("padding", "0px");
        frstLayout.getStyle().set("background-image", "url(" + src + ")");
        frstLayout.getStyle().set("background-size", "cover");

        if (isFeatured)
            frstLayout.add(ftured);

        HorizontalLayout hl = new HorizontalLayout(frstLayout);
        hl.setWidthFull();

        H5 title = new H5(name);
        title.getStyle().set("margin", "0px");

        Span yearm = new Span("Manufactured: " + year);
        yearm.getStyle().set("color", "gray");
        yearm.getStyle().set("margin", "0px");
        yearm.getStyle().set("margin-top", "5px");
        yearm.getStyle().set("font-size", "15px");

        Span price = new Span("RM " + UIUtils.formatAmount(cost));
        price.getStyle().set("color", "red");
        price.getStyle().set("margin", "0px");
        price.getStyle().set("font-size", "15px");

        Icon icon = VaadinIcon.HEART_O.create();
        icon.setColor("red");
        icon.setSize("19px");

        icon.addClickListener(iconClickEvent -> MainView.displayNotification(true, "Todo"));

        VerticalLayout favHolder = new VerticalLayout(icon);
        favHolder.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        favHolder.getStyle().set("padding", "0px");
        favHolder.getStyle().set("padding-right", "6px");
        favHolder.getStyle().set("margin-left", "0px");
        favHolder.setWidth("fit-content");


        VerticalLayout vl = new VerticalLayout(title, yearm, price);
        vl.getStyle().set("margin-left", "0px");
        vl.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);


        hl.addAndExpand(vl);
        hl.add(favHolder);
        card.add(hl);
        card.addClickListener(componentEvent -> {

            Map hasmap = new HashMap<>();
            hasmap.put("id", "1");
            hasmap.put("category", category.name());

            QueryParameters queryParameters = QueryParameters.simple(hasmap);
            getUI().get().navigate(ProductView.VIEW_NAME, queryParameters);
//            UI.getCurrent().navigate(ProductView.VIEW_NAME + "/" + 1)
        });
        return card;
    }

    /**
     * This model binds properties between ResultLayout and result-layout
     */
    public interface ResultLayoutModel extends TemplateModel {
        // Add setters and getters for template properties here.
        void setCat(String cat);

    }
}
