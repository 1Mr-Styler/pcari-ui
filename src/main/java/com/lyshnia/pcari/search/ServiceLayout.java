package com.lyshnia.pcari.search;

import com.lyshnia.pcari.DashboardView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the service-layout template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("service-layout")
@JsModule("./views/service-layout.js")
public class ServiceLayout extends PolymerTemplate<ServiceLayout.ServiceLayoutModel> {

    @Id("backButton")
    private Button backButton;
    @Id("servicesLayout")
    private Element servicesLayout;
    @Id("carButton")
    private Button carButton;
    @Id("bikeButton")
    private Button bikeButton;
    @Id("truckButton")
    private Button truckButton;
    @Id("ironIcon")
    private Element ironIcon;
    @Id("servicesButton")
    private Button servicesButton;
    @Id("washButton")
    private Button washButton;
    @Id("towingButton")
    private Button towingButton;
    @Id("bodyButton")
    private Button bodyButton;
    @Id("searchButton")
    private Button searchButton;

    /**
     * Creates a new ServiceLayout.
     */
    public ServiceLayout() {
        // You can initialise any data required for the connected UI components here.
        backButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(DashboardView.class));


        carButton.addClickListener(buttonClickEvent -> {
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            bikeButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            truckButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            ironIcon.setAttribute("src", "icons/motorcycle.svg");
        });

        bikeButton.addClickListener(buttonClickEvent -> {
            ironIcon.setAttribute("src", "icons/motorcycle-i.svg");
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            carButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            truckButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        truckButton.addClickListener(buttonClickEvent -> {
            ironIcon.setAttribute("src", "icons/motorcycle.svg");
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            bikeButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            carButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        servicesButton.addClickListener(buttonClickEvent -> {
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            washButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            towingButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            bodyButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        washButton.addClickListener(buttonClickEvent -> {
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            servicesButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            towingButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            bodyButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        towingButton.addClickListener(buttonClickEvent -> {
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            servicesButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            washButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            bodyButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        bodyButton.addClickListener(buttonClickEvent -> {
            buttonClickEvent.getSource().addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
            servicesButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            towingButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
            washButton.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
        });

        searchButton.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate(ResultView.VIEW_NAME + "/" + Category.Services);
        });

    }

    /**
     * This model binds properties between ServiceLayout and service-layout
     */
    public interface ServiceLayoutModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
