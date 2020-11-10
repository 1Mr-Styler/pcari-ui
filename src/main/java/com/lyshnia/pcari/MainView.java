package com.lyshnia.pcari;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.*;
import com.lyshnia.pcari.auth.AccessControl;
import com.lyshnia.pcari.auth.AccessControlFactory;
import com.lyshnia.pcari.auth.BasicAccessControl;
import com.lyshnia.pcari.navigation.bar.AppBar;
import com.lyshnia.pcari.navigation.bar.TabBar;
import com.lyshnia.pcari.navigation.drawer.NaviDrawer;
import com.lyshnia.pcari.navigation.drawer.NaviItem;
import com.lyshnia.pcari.navigation.drawer.NaviMenu;
import com.lyshnia.pcari.ui.FlexBoxLayout;
import com.lyshnia.pcari.ui.util.BoxShadowBorders;
import com.lyshnia.pcari.ui.util.UIUtils;
import com.lyshnia.pcari.ui.util.css.Overflow;
import com.lyshnia.pcari.user.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.*;
import com.vaadin.flow.theme.lumo.Lumo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * The main view contains a button and a click listener.
 */
@PWA(name = "Lyshnia POS", shortName = "POS", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
@CssImport(value = "./styles/components/floating-action-button.css", themeFor = "vaadin-button")
@CssImport(value = "./styles/components/grid.css", themeFor = "vaadin-grid")
@CssImport("./styles/lumo/border-radius.css")
@CssImport("./styles/lumo/icon-size.css")
@CssImport("./styles/lumo/margin.css")
@CssImport("./styles/lumo/padding.css")
@CssImport("./styles/shared-styles.css")
@CssImport("./styles/lumo/shadow.css")
@CssImport("./styles/lumo/spacing.css")
@CssImport("./styles/lumo/typography.css")
@CssImport("./styles/misc/box-shadow-borders.css")
@CssImport(value = "./styles/styles.css", include = "lumo-badge")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@JsModule("@vaadin/vaadin-lumo-styles/badge")
public class MainView extends FlexBoxLayout
        implements RouterLayout, PageConfigurator, AfterNavigationObserver {

    private static final Logger log = LoggerFactory.getLogger(MainView.class);
    private static final String CLASS_NAME = "root";
    public static ZoneId ZONE_ID = ZoneId.of("Africa/Lagos");
    public static AccessControl accessControl = new BasicAccessControl();

    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
        @Override
        public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8010/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    public static Cloudinary cloudinary = new
            Cloudinary(ObjectUtils.asMap(
            "cloud_name", "lyshnia-limited",
            "api_key", "739118628765371",
            "api_secret", "8ox179PXwdYqX4C07Zchct0A2l0"));
    private NaviDrawer naviDrawer;
    private Div appHeaderOuter;

    private FlexBoxLayout row;
    private FlexBoxLayout column;

    private Div appHeaderInner;
    private FlexBoxLayout viewContainer;
    private Div appFooterInner;

    private Div appFooterOuter;

    private TabBar tabBar;
    private boolean navigationTabs = false;
    private AppBar appBar;

    public MainView() {
        accessControl = AccessControlFactory.getInstance().createAccessControl();

        VaadinSession.getCurrent()
                .setErrorHandler((ErrorHandler) errorEvent -> {
                    log.error("Uncaught UI exception",
                            errorEvent.getThrowable());
                    Notification.show(
                            "We are sorry, but an internal error occurred");
                });

        addClassName(CLASS_NAME);
        setFlexDirection(FlexDirection.COLUMN);
        setSizeFull();


        naviDrawer = new NaviDrawer();

        // Initialise the UI building blocks
        initStructure();

        // Populate the navigation drawer
        initNaviItems();

        // Configure the headers and footers (optional)
        initHeadersAndFooters();

    }

    public static MainView get() {
        return (MainView) UI.getCurrent().getChildren()
                .filter(component -> component.getClass() == MainView.class)
                .findFirst().get();
    }

    public static String processPhone(String phone) {
        if (phone.contains("+234")) {
            return phone;
        }

        return "+234" + phone.substring(1);
    }

    public static void displayNotification(boolean success, String msg) {
        Notification notification = new Notification();
        if (success) {
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } else notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Label label = new Label(msg);

        Button openSiteButton = new Button("Close",
                e -> {
                    notification.close();
                });
        openSiteButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        notification.add(label, openSiteButton);

        label.getStyle().set("margin-right", "0.5rem");

        notification.setDuration(3000);

        notification.open();
    }

    /**
     * Initialise the required components and containers.
     */
    private void initStructure() {
        naviDrawer = new NaviDrawer();

        viewContainer = new FlexBoxLayout();
        viewContainer.addClassName(CLASS_NAME + "__view-container");
        viewContainer.setOverflow(Overflow.HIDDEN);

        column = new FlexBoxLayout(viewContainer);
        column.addClassName(CLASS_NAME + "__column");
        column.setFlexDirection(FlexDirection.COLUMN);
        column.setFlexGrow(1, viewContainer);
        column.setOverflow(Overflow.HIDDEN);

        row = new FlexBoxLayout(naviDrawer, column);
        row.addClassName(CLASS_NAME + "__row");
        row.setFlexGrow(1, column);
        row.setOverflow(Overflow.HIDDEN);
        add(row);
        setFlexGrow(1, row);
    }

    /**
     * Initialise the navigation items.
     */
    private void initNaviItems() {
        NaviMenu menu = naviDrawer.getMenu();
        User user = accessControl.getUserInfo();
        menu.addNaviItem(VaadinIcon.HOME, "Home", HomeView.class);
//        menu.addNaviItem(VaadinIcon.RECORDS, "Orders", BookingView.class);
//        User user = accessControl.getUserInfo();


    }

    /**
     * Configure the app's inner and outer headers and footers.
     */
    private void initHeadersAndFooters() {
        // setAppHeaderOuter();
//        setAppFooterInner();
        // setAppFooterOuter();

        // Default inner header setup:
        // - When using tabbed navigation the view title, user avatar and main menu button will appear in the TabBar.
        // - When tabbed navigation is turned off they appear in the AppBar.

        appBar = new AppBar("Dashboard");

        // Tabbed navigation
        if (navigationTabs) {
            tabBar = new TabBar();
            UIUtils.setTheme(Lumo.DARK, tabBar);

            // Shift-click to add a new tab
            for (NaviItem item : naviDrawer.getMenu().getNaviItems()) {
                item.addClickListener(e -> {
                    if (e.getButton() == 0 && e.isShiftKey()) {
                        tabBar.setSelectedTab(tabBar.addClosableTab(item.getText(), item.getNavigationTarget()));
                    }
                });
            }
            appBar.getAvatar().setVisible(false);
            setAppHeaderInner(tabBar, appBar);

            // Default navigation
        } else {
            UIUtils.setTheme(Lumo.DARK, appBar);
            setAppHeaderInner(appBar);
        }
    }

    private void setAppHeaderOuter(Component... components) {
        if (appHeaderOuter == null) {
            appHeaderOuter = new Div();
            appHeaderOuter.addClassName("app-header-outer");
            getElement().insertChild(0, appHeaderOuter.getElement());
        }
        appHeaderOuter.removeAll();
        appHeaderOuter.add(components);
    }

    private void setAppHeaderInner(Component... components) {
        if (appHeaderInner == null) {
            appHeaderInner = new Div();
            appHeaderInner.addClassName("app-header-inner");
            column.getElement().insertChild(0, appHeaderInner.getElement());
        }
        appHeaderInner.removeAll();
        appHeaderInner.add(components);
    }

    private void setAppFooterInner(Component... components) {
        if (appFooterInner == null) {
            appFooterInner = new Div();
            appFooterInner.addClassName("app-footer-inner");
            column.getElement().insertChild(column.getElement().getChildCount(),
                    appFooterInner.getElement());
        }

        // Set background color and shadow
        /*UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, footer);
        UIUtils.setShadow(Shadow.L, footer);*/

        appFooterInner.addClassName(BoxShadowBorders.TOP);

        appFooterInner.removeAll();
        appFooterInner.add(components);
    }

    private void setAppFooterOuter(Component... components) {
        if (appFooterOuter == null) {
            appFooterOuter = new Div();
            appFooterOuter.addClassName("app-footer-outer");
            getElement().insertChild(getElement().getChildCount(),
                    appFooterOuter.getElement());
        }
        appFooterOuter.removeAll();
        appFooterOuter.add(components);
    }

    @Override
    public void configurePage(InitialPageSettings settings) {
        settings.addMetaTag("apple-mobile-web-app-capable", "yes");
        settings.addMetaTag("apple-mobile-web-app-status-bar-style", "black");

        settings.addFavIcon("icon", "frontend/images/favicons/favicon.ico",
                "256x256");
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        this.viewContainer.getElement().appendChild(content.getElement());
    }

    public NaviDrawer getNaviDrawer() {
        return naviDrawer;
    }

    public AppBar getAppBar() {
        return appBar;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (navigationTabs) {
            afterNavigationWithTabs(event);
        } else {
            afterNavigationWithoutTabs(event);
        }
    }

    private void afterNavigationWithTabs(AfterNavigationEvent e) {
        NaviItem active = getActiveItem(e);
        if (active == null) {
            if (tabBar.getTabCount() == 0) {
                tabBar.addClosableTab("", HomeView.class);
            }
        } else {
            if (tabBar.getTabCount() > 0) {
                tabBar.updateSelectedTab(active.getText(),
                        active.getNavigationTarget());
            } else {
                tabBar.addClosableTab(active.getText(),
                        active.getNavigationTarget());
            }
        }
        appBar.getMenuIcon().setVisible(false);
    }

    private NaviItem getActiveItem(AfterNavigationEvent e) {
        for (NaviItem item : naviDrawer.getMenu().getNaviItems()) {
            if (item.isHighlighted(e)) {
                return item;
            }
        }
        return null;
    }

    private void afterNavigationWithoutTabs(AfterNavigationEvent e) {
        NaviItem active = getActiveItem(e);
        if (active != null) {
            getAppBar().setTitle(active.getText());
        }
    }


}
