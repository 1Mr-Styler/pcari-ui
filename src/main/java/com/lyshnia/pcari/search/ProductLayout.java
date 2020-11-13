package com.lyshnia.pcari.search;

import com.github.appreciated.card.ClickableCard;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.ui.util.UIUtils;
import com.lyshnia.pcari.ui.util.css.BorderRadius;
import com.lyshnia.pcari.ui.util.css.Shadow;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the product-layout template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("product-layout")
@JsModule("./views/product-layout.js")
public class ProductLayout extends PolymerTemplate<ProductLayout.ProductLayoutModel> {

    @Id("imgScroll")
    private HorizontalLayout imgScroll;
    @Id("scrollingLayout")
    private VerticalLayout scrollingLayout;
    @Id("headerLayout")
    private Element headerLayout;
    @Id("vaadinTabs")
    private Tabs vaadinTabs;
    @Id("tabInfoLayout")
    private VerticalLayout tabInfoLayout;

    /**
     * Creates a new ProductLayout.
     */
    public ProductLayout(Long id, String category) {
        // You can initialise any data required for the connected UI components here.
        imgScroll.add(createImageCard("images/asx.jpg"));
        imgScroll.add(createImageCard("images/cooper.jpg"));
        imgScroll.add(createImageCard("images/van.jpg"));
        imgScroll.add(createImageCard("images/cooper.jpg"));
        imgScroll.add(createImageCard("images/asx.jpg"));
        imgScroll.add(createImageCard("images/cooper.jpg"));


        MainView.get().getAppBar().setVisible(true);
        MainView.get().getAppBar().getAvatar().setVisible(false);
        MainView.get().getAppBar().getMenuIcon().setVisible(false);
        MainView.get().getAppBar().getContextIcon().setVisible(true);
        MainView.get().getAppBar().setTitle("Nissan Vanette 2.5");
        MainView.get().getAppBar().getContextIcon()
                .addClickListener(buttonClickEvent -> UI.getCurrent().navigate(ResultView.VIEW_NAME + "/" + category));


        getModel().setTitle("Seller Pitch");

        vaadinTabs.addSelectedChangeListener(selectedChangeEvent -> {
            if (selectedChangeEvent.getSelectedTab().getLabel().equals("Pitch")) {
                tabInfoLayout.removeAll();
                tabInfoLayout.add("Seller Pitch");

                tabInfoLayout.add(new Html(
                        "<pre>MERCEDES BENZ E43 AMG 4MATIC\n" +
                                "** PREMIUM PLUS PACKAGE **\n" +
                                "Manufacture year 2017 Unreg\n" +
                                "U.K. Premium Selection Condition\n" +
                                "Local Platinum AP Holder **30 years experience**\n" +
                                "\n" +
                                "Please contact ERIN before viewing Show contact number\n" +
                                "Please contact PUNG before viewing Show contact number\n" +
                                "\n" +
                                "Performances:\n" +
                                "• 3.0L Biturbocharged V6 \n" +
                                "• 9G-Tronic Automatic Transmission\n" +
                                "• Horsepower: 396 hp (401 PS) at 6,100 rpm, 0-100kmh 4.5sec)\n" +
                                "• Torque: 520 Nm of torque between 2,500 to 5,000 rpm</pre>"
                ));
            } else if (selectedChangeEvent.getSelectedTab().getLabel().equals("Tech Specs")) {
                tabInfoLayout.removeAll();
                tabInfoLayout.add("Technical Specification");
                tabInfoLayout.add(createTableThing());
            } else {
                tabInfoLayout.removeAll();
                tabInfoLayout.add("Extras");
                tabInfoLayout.add(new Span("No Extras"));

            }
        });

        // Profile Card
        HorizontalLayout pLayout = new HorizontalLayout();

        pLayout.getStyle().set("margin", "var(--lumo-space-m)");
        pLayout.setHeight("45px");
        pLayout.getStyle().set("align-self", "stretch");
        pLayout.getStyle().set("padding-left", "var(--lumo-space-m)");
        pLayout.getStyle().set("padding-right", "var(--lumo-space-m)");
        pLayout.add(VaadinIcon.USER.create());
        pLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        UIUtils.setShadow(Shadow.S, pLayout);
        UIUtils.setBorderRadius(BorderRadius.S, pLayout);

        pLayout.add(new Label("Ahmed haafiz".toUpperCase()));

        Button follow = new Button("Follow");
        follow.getStyle().set("border", "1px solid");
        follow.getStyle().set("margin-left", "auto");
        follow.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL);

        pLayout.add(follow);

        scrollingLayout.add(pLayout);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        vaadinTabs.add(new Tab("Pitch"), new Tab("Tech Specs"), new Tab("Extras"));
    }

    private Component createImageCard(String src) {
        ClickableCard card = new ClickableCard();
        card.setWidth("140px");

        VerticalLayout frstLayout = new VerticalLayout();
        frstLayout.setWidth("140px");
        frstLayout.setMinWidth("140px");
        frstLayout.setHeight("140px");
        frstLayout.getStyle().set("padding", "0px");
        frstLayout.getStyle().set("background-image", "url(" + src + ")");
        frstLayout.getStyle().set("background-size", "cover");

        card.getStyle().set("margin-bottom", "3px");
        card.add(frstLayout);

        card.addClickListener(componentEvent -> headerLayout.getStyle().set("background-image", "url(" + src + ")"));
        return card;
    }

    private Component createTableThing() {
        return new Html("<table style = 'border-collapse: collapse;     border-spacing: 0;     width: 100%;     border: 1px solid #ddd;'>\n" +
                "<style>td{text-align: center; padding: 16px;} tr:nth-child(even) {   background-color: #f2f2f2 }</style>" +
                "  <tr>\n" +
                "    <td>Mileage</td>\n" +
                "    <td>15247km</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Manufacturing Year</td>\n" +
                "    <td>2018</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Fuel Type</td>\n" +
                "    <td>Petrol</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Drive Wheel</td>\n" +
                "    <td>FWD</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Transmission</td>\n" +
                "    <td>Automatic</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Condition</td>\n" +
                "    <td>Used</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Vehicle Make</td>\n" +
                "    <td>MINI</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Vehicle Model</td>\n" +
                "    <td>5 Door</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Vehicle Variant</td>\n" +
                "    <td>2.0 Cooper S</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Body Type</td>\n" +
                "    <td>Hatchback</td>\n" +
                "  </tr>\n" +
                "</table>");
    }

    /**
     * This model binds properties between ProductLayout and product-layout
     */
    public interface ProductLayoutModel extends TemplateModel {
        // Add setters and getters for template properties here.

        void setTitle(String title);
    }
}
