package com.lyshnia.pcari.auth;

import com.lyshnia.pcari.user.User;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import java.util.concurrent.TimeUnit;

public final class CurrentUser {
    /**
     * The attribute key used to store the username in the session.
     */
    public static final String CURRENT_USER_SESSION_ATTRIBUTE_KEY = CurrentUser.class
            .getCanonicalName() + "HBALEND";
    /**
     * The attribute key used to store the user details in the session.
     */
    public static final String CURRENT_USER_DETAILS_ATTRIBUTE_KEY = "USRD" + "HBALEND";

    public static final String CURRENT_OQ_SESSION_ATTRIBUTE_KEY = CurrentUser.class
            .getCanonicalName() + "OQ";

    private CurrentUser() {
    }

    /**
     * Returns the name of the current user stored in the current session, or an
     * empty string if no user name is stored.
     *
     * @throws IllegalStateException if the current session cannot be accessed.
     */
    public static User get() {
        User currentUser = (User) getCurrentRequest().getWrappedSession()
                .getAttribute(CURRENT_USER_DETAILS_ATTRIBUTE_KEY);
        if (currentUser == null) {
            return null;
        } else {
            return currentUser;
        }
    }

    public static LoginDetails getLogin() {
        LoginDetails loginDetails = (LoginDetails) getCurrentRequest().getWrappedSession()
                .getAttribute(CURRENT_USER_SESSION_ATTRIBUTE_KEY);

        if (loginDetails == null) {
            return null;
        } else {
            return loginDetails;
        }
    }

    /**
     * Sets the name of the current user and stores it in the current session.
     * Using a {@code null} username will remove the username from the session.
     *
     * @throws IllegalStateException if the current session cannot be accessed.
     */
    public static void set(LoginDetails currentUser, User user) {
        if (currentUser == null) {
            System.out.println("Session is null");
            getCurrentRequest().getWrappedSession().removeAttribute(
                    CURRENT_USER_SESSION_ATTRIBUTE_KEY);
            getCurrentRequest().getWrappedSession().removeAttribute(
                    CURRENT_USER_DETAILS_ATTRIBUTE_KEY);
        } else {
            VaadinSession               // Wraps a standard Servlet session.
                    .getCurrent()               // Access the current user’s session.
                    .getSession()               // Access the wrapped standard Servlet session.
                    .setMaxInactiveInterval(    // Set the timeout.
                            (int)                 // Cast a `long` to an `int`.
                                    TimeUnit                // The `TimeUnit` enum is more self-documenting than using a literal integer number.
                                            .MINUTES                // Here we set a half hour, 30 minutes.
                                            .toSeconds(31104000)        // Set a number of whole seconds.
                    )
            ;
            getCurrentRequest().getWrappedSession().setAttribute(
                    CURRENT_USER_SESSION_ATTRIBUTE_KEY, currentUser);

            getCurrentRequest().getWrappedSession().setAttribute(
                    CURRENT_USER_DETAILS_ATTRIBUTE_KEY, user);
        }
    }

    private static VaadinRequest getCurrentRequest() {
        VaadinRequest request = VaadinService.getCurrentRequest();
        if (request == null) {
            throw new IllegalStateException(
                    "No request bound to current thread.");
        }
        return request;
    }

    /*public static HashSet<OrderQuantity> getOQ() {
        HashSet<OrderQuantity> orderQuantities = (HashSet<OrderQuantity>) getCurrentRequest().getWrappedSession()
                .getAttribute(CURRENT_OQ_SESSION_ATTRIBUTE_KEY);
        if (orderQuantities == null) {
            return new HashSet<>();
        } else {
            return orderQuantities;
        }
    }

    public static void setOQ(HashSet<OrderQuantity> orderQuantities) {
        if (orderQuantities == null) {
            System.out.println("OQ Session is null");
            getCurrentRequest().getWrappedSession().removeAttribute(
                    CURRENT_OQ_SESSION_ATTRIBUTE_KEY);
        } else {
            VaadinSession               // Wraps a standard Servlet session.
                    .getCurrent()               // Access the current user’s session.
                    .getSession()               // Access the wrapped standard Servlet session.
                    .setMaxInactiveInterval(    // Set the timeout.
                            (int)                 // Cast a `long` to an `int`.
                                    TimeUnit                // The `TimeUnit` enum is more self-documenting than using a literal integer number.
                                            .MINUTES                // Here we set a half hour, 30 minutes.
                                            .toSeconds(31104000)        // Set a number of whole seconds.
                    )
            ;
            HashSet<OrderQuantity> orderQuantityHashSet = new HashSet<>(orderQuantities);
            getCurrentRequest().getWrappedSession().setAttribute(
                    CURRENT_OQ_SESSION_ATTRIBUTE_KEY, orderQuantityHashSet);
        }
    }*/
}
