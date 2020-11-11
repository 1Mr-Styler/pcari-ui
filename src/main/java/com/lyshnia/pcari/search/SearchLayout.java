package com.lyshnia.pcari.search;

import com.infraleap.animatecss.Animated;
import com.lyshnia.pcari.DashboardView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the search-layout template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("search-layout")
@JsModule("./views/search-layout.js")
@CssImport(value = "./styles/ordinary.css", themeFor = "vaadin-select-text-field")
@JavaScript("https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js")
public class SearchLayout extends PolymerTemplate<SearchLayout.SearchLayoutModel> implements Animated {

    @Id("backButton")
    private Button backButton;
    @Id("brandSelect")
    private Select<String> brandSelect;
    @Id("modelsSelect")
    private Select<String> modelsSelect;
    @Id("variantsSelect")
    private Select<String> variantsSelect;
    @Id("searchButton")
    private Button searchButton;

    /**
     * Creates a new SearchLayout.
     */
    public SearchLayout(Category category) {
        // You can initialise any data required for the connected UI components here.
        backButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(DashboardView.class));

        getModel().setCat(category.name());

        brandSelect.setItems("Any brand", "AMG", "Brabus", "Maybach", "BluTech");

        this.animate(Animation.BACK_IN_LEFT);

        searchButton.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate(ResultView.VIEW_NAME + "/" + category.name());
        });

    }

    /**
     * This model binds properties between SearchLayout and search-layout
     */
    public interface SearchLayoutModel extends TemplateModel {
        // Add setters and getters for template properties here.

        void setCat(String cat);
    }
}
