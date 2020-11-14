package com.lyshnia.pcari.app;

import com.github.appreciated.card.ClickableCard;
import com.lyshnia.pcari.search.SearchView;
import com.lyshnia.pcari.user.DealerView;
import com.lyshnia.pcari.user.ProfileView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the dashboard-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("dashboard-view")
@JsModule("./views/dashboard-view.js")
public class DashboardView extends PolymerTemplate<DashboardView.DashboardViewModel> {

    @Id("servicesLayout")
    private HorizontalLayout servicesLayout;
    @Id("fdealersLayout")
    private HorizontalLayout fdealersLayout;
    @Id("fpostLayout")
    private HorizontalLayout fpostLayout;
    @Id("fdealLayout")
    private HorizontalLayout fdealLayout;
    @Id("userIcon")
    private Image userIcon;

    /**
     * Creates a new DashboardView.
     */
    public DashboardView() {
        // You can initialise any data required for the connected UI components here.
        servicesLayout.add(createServiceCard("Car", "icons/car.svg"));
        servicesLayout.add(createServiceCard("Motorcycle", "icons/cyc.svg"));
        servicesLayout.add(createServiceCard("Commercial", "icons/com.svg"));
        servicesLayout.add(createServiceCard("Services", "icons/ser.svg"));

        fpostLayout.add(createFPCard("MINI COOPER S", "images/cooper.jpg"));
        fpostLayout.add(createFPCard("MITSUBISHI ASX 2.0 4AWD FACELIFT (AT)", "images/asx.jpg"));
        fpostLayout.add(createFPCard("MITSUBISHI ASX 2.0 4AWD FACELIFT (AT)", "images/asx.jpg"));


        fdealersLayout.add(createFDCard("Utama Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Kenghim Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Utama Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Kenghim Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Utama Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Kenghim Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Utama Motors", "images/asx.jpg", 1l));
        fdealersLayout.add(createFDCard("Kenghim Motors", "images/asx.jpg", 1l));

        fdealLayout.add(createFPCard("MINI COOPER S", "images/cooper.jpg"));
        fdealLayout.add(createFPCard("MITSUBISHI ASX 2.0 4AWD FACELIFT (AT)", "images/asx.jpg"));
        fdealLayout.add(createFPCard("MITSUBISHI ASX 2.0 4AWD FACELIFT (AT)", "images/asx.jpg"));

        userIcon.addClickListener(imageClickEvent -> launchProfile());
    }

    public Component createServiceCard(String service, String img) {
        VerticalLayout vl = new VerticalLayout();
        ClickableCard card = new ClickableCard();
        card.setHeight("80px");
        card.setWidth("80px");
        card.getChildren().findFirst().get().getElement().getStyle().set("background-color", "white");
        ((VerticalLayout) card.getChildren().findFirst().get()).setAlignItems(FlexComponent.Alignment.CENTER);
        ((VerticalLayout) card.getChildren().findFirst().get()).setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        Image image = new Image(img, service);
        image.setWidth("70px");
        card.add(image);

        Label label = new Label(service);
        label.getStyle().set("font-size", "small");

        vl.add(card, label);
        vl.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        vl.setAlignItems(FlexComponent.Alignment.CENTER);
        vl.setSpacing(false);
        vl.setPadding(false);
        vl.getStyle().set("margin", "0px");

        card.addClickListener(componentEvent -> {
            getUI().get().navigate(SearchView.VIEW_NAME + "/" + service);
        });

        return vl;
    }

    public Component createFPCard(String service, String img) {
        ClickableCard card = new ClickableCard();
        card.setHeight("110px");
        card.setWidth("200px");
        card.setMinWidth("200px");
        card.getChildren().findFirst().get().getElement().getStyle().set("background-image", "url(" + img + ")");

        Label label = new Label(service);
        label.getStyle().set("font-size", "10px");
        label.getStyle().set("margin-left", "23px");

        HorizontalLayout hl = new HorizontalLayout(label);
        hl.getStyle().set("background-color", "rgba(192,192,192,0.7)");
        hl.setWidthFull();
        hl.setHeight("32px");
        hl.setAlignItems(FlexComponent.Alignment.CENTER);


        ((VerticalLayout) card.getChildren().findFirst().get()).setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        card.add(hl);

        return card;
    }

    public Component createFDCard(String dealer, String logo, Long id) {
        ClickableCard card = new ClickableCard();
        card.setWidth("120px");
        card.setMinWidth("120px");
        card.setHeight("190px");


        Image image = new Image(logo, dealer);
        image.setWidth("70px");
        image.setHeight("70px");
        image.getStyle().set("border-radius", "50%");


        Label label = new Label(dealer);
        label.getStyle().set("font-size", "13px");
        label.getStyle().set("font-weight", "bold");
        label.getStyle().set("padding-left", "5px");
        label.getStyle().set("padding-top", "13px");

        Span span = new Span("43 Total Ads");
        span.getStyle().set("font-size", "10px");
        span.getStyle().set("padding-left", "5px");
        span.getStyle().set("color", "gray");


//        ((VerticalLayout) card.getChildren().findFirst().get()).getStyle().set("padding-left", "10px");

        HorizontalLayout imageLayout = new HorizontalLayout(image);
        imageLayout.setWidthFull();
        imageLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        HorizontalLayout lastLayout = new HorizontalLayout();
        Icon star = VaadinIcon.STAR.create();
        star.getStyle().set("width", "10px");
        star.getStyle().set("padding-left", "5px");

        Span span2 = new Span("4.7");
        span2.getStyle().set("font-size", "10px");
        span2.getStyle().set("padding-left", "2px");
        lastLayout.add(star);
        lastLayout.add(span2);

        lastLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        lastLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        lastLayout.setSpacing(false);


        Button button = new Button("Profile");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SMALL);
        button.getStyle().set("align-self", "center");

        card.add(imageLayout, label, span, lastLayout, button);

        button.addClickListener(componentEvent -> {
            UI.getCurrent().navigate(DealerView.VIEW_NAME + "/" + dealer);
        });

        return card;
    }

    public void launchProfile() {
        Dialog dialog = new Dialog();
        dialog.add(new ProfileView(dialog));
        dialog.setModal(true);
        dialog.setWidth("100vw");
        dialog.setHeight("100vh");
        dialog.getElement().getStyle().set("padding", "0px");
        dialog.open();
    }

    /**
     * This model binds properties between DashboardView and dashboard-view
     */
    public interface DashboardViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
