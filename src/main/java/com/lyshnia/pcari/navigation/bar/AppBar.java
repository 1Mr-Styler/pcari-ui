package com.lyshnia.pcari.navigation.bar;

import com.lyshnia.pcari.HomeView;
import com.lyshnia.pcari.MainView;
import com.lyshnia.pcari.navigation.tab.NaviTab;
import com.lyshnia.pcari.navigation.tab.NaviTabs;
import com.lyshnia.pcari.ui.FlexBoxLayout;
import com.lyshnia.pcari.ui.util.LumoStyles;
import com.lyshnia.pcari.ui.util.UIUtils;
import com.lyshnia.pcari.user.Logout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;

import java.util.ArrayList;

import static com.lyshnia.pcari.ui.util.UIUtils.IMG_PATH;


@CssImport("./styles/components/app-bar.css")
public class AppBar extends FlexBoxLayout {

    private String CLASS_NAME = "app-bar";

    private FlexBoxLayout container;

    private Button menuIcon;
    private Button contextIcon;

    private H4 title;
    private FlexBoxLayout actionItems;
    private Image avatar;

    private FlexBoxLayout tabContainer;
    private NaviTabs tabs;
    private ArrayList<Registration> tabSelectionListeners;
    private Button addTab;

    private TextField search;
    private Registration searchRegistration;

    public AppBar(String title, NaviTab... tabs) {
        setClassName(CLASS_NAME);

        initMenuIcon();
        initContextIcon();
        initTitle(title);
        initSearch();
        initAvatar();
        initActionItems();
        initContainer();
        initTabs(tabs);
    }

    public void setNaviMode(NaviMode mode) {
        if (mode.equals(NaviMode.MENU)) {
            menuIcon.setVisible(true);
            contextIcon.setVisible(false);
        } else {
            menuIcon.setVisible(false);
            contextIcon.setVisible(true);
        }
    }

    private void initMenuIcon() {
        menuIcon = UIUtils.createTertiaryInlineButton(VaadinIcon.MENU);
        menuIcon.addClassName(CLASS_NAME + "__navi-icon");
        menuIcon.addClickListener(e -> MainView.get().getNaviDrawer().toggle());
        UIUtils.setAriaLabel("Menu", menuIcon);
        UIUtils.setLineHeight("1", menuIcon);
    }

    private void initContextIcon() {
        contextIcon = UIUtils
                .createTertiaryInlineButton(VaadinIcon.ARROW_LEFT);
        contextIcon.addClassNames(CLASS_NAME + "__context-icon");
        contextIcon.setVisible(false);
        contextIcon.addThemeVariants(ButtonVariant.LUMO_ERROR);
        UIUtils.setAriaLabel("Back", contextIcon);
        UIUtils.setLineHeight("1", contextIcon);

    }

    private void initTitle(String title) {
        this.title = new H4(title);
        this.title.setClassName(CLASS_NAME + "__title");
        this.title.getStyle().set("color", "black");
    }

    private void initSearch() {
        search = new TextField();
        search.setPlaceholder("Search");
        search.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        search.setVisible(false);
    }

    private void initAvatar() {
        avatar = new Image();
        avatar.setClassName(CLASS_NAME + "__avatar");
        avatar.setSrc(IMG_PATH + "avatar.png");
        avatar.setAlt("User menu");

        ContextMenu contextMenu = new ContextMenu(avatar);
        contextMenu.setOpenOnClick(true);
        contextMenu.addItem("Settings",
                e -> Notification.show("Not implemented yet.", 3000,
                        Notification.Position.BOTTOM_CENTER));
        contextMenu.addItem("Log Out",
                e -> UI.getCurrent().navigate(Logout.VIEW_NAME));
    }

    private void initActionItems() {
        actionItems = new FlexBoxLayout();
        actionItems.addClassName(CLASS_NAME + "__action-items");
        actionItems.setVisible(false);
    }

    private void initContainer() {
        container = new FlexBoxLayout(menuIcon, contextIcon, this.title, search,
                actionItems, avatar);
        container.addClassName(CLASS_NAME + "__container");
        container.setAlignItems(FlexComponent.Alignment.CENTER);
        container.setFlexGrow(1, search);
        add(container);
    }

    private void initTabs(NaviTab... tabs) {
        addTab = UIUtils.createSmallButton(VaadinIcon.PLUS);
        addTab.addClickListener(e -> this.tabs
                .setSelectedTab(addClosableNaviTab("New Tab", HomeView.class)));
        addTab.setVisible(false);

        this.tabs = tabs.length > 0 ? new NaviTabs(tabs) : new NaviTabs();
        this.tabs.setClassName(CLASS_NAME + "__tabs");
        this.tabs.setVisible(false);
        for (NaviTab tab : tabs) {
            configureTab(tab);
        }

        this.tabSelectionListeners = new ArrayList<>();

        tabContainer = new FlexBoxLayout(this.tabs, addTab);
        tabContainer.addClassName(CLASS_NAME + "__tab-container");
        tabContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        add(tabContainer);
    }

    public Button getMenuIcon() {
        return menuIcon;
    }

    /* === MENU ICON === */

    public Button getContextIcon() {
        return contextIcon;
    }

    /* === CONTEXT ICON === */

    public void setContextIcon(Icon icon) {
        contextIcon.setIcon(icon);
    }

    public String getTitle() {
        return this.title.getText();
    }

    /* === TITLE === */

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public Component addActionItem(Component component) {
        actionItems.add(component);
        updateActionItemsVisibility();
        return component;
    }

    /* === ACTION ITEMS === */

    public Button addActionItem(VaadinIcon icon) {
        Button button = UIUtils.createButton(icon, ButtonVariant.LUMO_SMALL,
                ButtonVariant.LUMO_TERTIARY);
        addActionItem(button);
        return button;
    }

    public void removeAllActionItems() {
        actionItems.removeAll();
        updateActionItemsVisibility();
    }

    public Image getAvatar() {
        return avatar;
    }

    /* === AVATAR == */

    public void centerTabs() {
        tabs.addClassName(LumoStyles.Margin.Horizontal.AUTO);
    }

    /* === TABS === */

    private void configureTab(Tab tab) {
        tab.addClassName(CLASS_NAME + "__tab");
        updateTabsVisibility();
    }

    public Tab addTab(String text) {
        Tab tab = tabs.addTab(text);
        configureTab(tab);
        return tab;
    }

    public Tab addTab(String text,
                      Class<? extends Component> navigationTarget) {
        Tab tab = tabs.addTab(text, navigationTarget);
        configureTab(tab);
        return tab;
    }

    public Tab addClosableNaviTab(String text,
                                  Class<? extends Component> navigationTarget) {
        Tab tab = tabs.addClosableTab(text, navigationTarget);
        configureTab(tab);
        return tab;
    }

    public Tab getSelectedTab() {
        return tabs.getSelectedTab();
    }

    public void setSelectedTab(Tab selectedTab) {
        tabs.setSelectedTab(selectedTab);
    }

    public void updateSelectedTab(String text,
                                  Class<? extends Component> navigationTarget) {
        tabs.updateSelectedTab(text, navigationTarget);
    }

    public void navigateToSelectedTab() {
        tabs.navigateToSelectedTab();
    }

    public void addTabSelectionListener(
            ComponentEventListener<Tabs.SelectedChangeEvent> listener) {
        Registration registration = tabs.addSelectedChangeListener(listener);
        tabSelectionListeners.add(registration);
    }

    public int getTabCount() {
        return tabs.getTabCount();
    }

    public void removeAllTabs() {
        tabSelectionListeners.forEach(registration -> registration.remove());
        tabSelectionListeners.clear();
        tabs.removeAll();
        updateTabsVisibility();
    }

    public void setAddTabVisible(boolean visible) {
        addTab.setVisible(visible);
    }

    /* === ADD TAB BUTTON === */

    public void searchModeOn() {
        menuIcon.setVisible(false);
        title.setVisible(false);
        actionItems.setVisible(false);
        tabContainer.setVisible(false);

        contextIcon.setIcon(new Icon(VaadinIcon.ARROW_BACKWARD));
        contextIcon.setVisible(true);
        searchRegistration = contextIcon
                .addClickListener(e -> searchModeOff());

        search.setVisible(true);
        search.focus();
    }

    /* === SEARCH === */

    public void addSearchListener(HasValue.ValueChangeListener listener) {
        search.addValueChangeListener(listener);
    }

    public void setSearchPlaceholder(String placeholder) {
        search.setPlaceholder(placeholder);
    }

    private void searchModeOff() {
        menuIcon.setVisible(true);
        title.setVisible(true);
        tabContainer.setVisible(true);

        updateActionItemsVisibility();
        updateTabsVisibility();

        contextIcon.setVisible(false);
        searchRegistration.remove();

        search.clear();
        search.setVisible(false);
    }

    public void reset() {
        title.setText("");
        setNaviMode(NaviMode.MENU);
        removeAllActionItems();
        removeAllTabs();
    }

    /* === RESET === */

    private void updateActionItemsVisibility() {
        actionItems.setVisible(actionItems.getComponentCount() > 0);
    }

    /* === UPDATE VISIBILITY === */

    private void updateTabsVisibility() {
        tabs.setVisible(tabs.getComponentCount() > 0);
    }

    public enum NaviMode {
        MENU, CONTEXTUAL
    }
}
