package com.lyshnia.pcari;

import com.lyshnia.pcari.auth.AccessControl;
import com.lyshnia.pcari.auth.AccessControlFactory;
import com.lyshnia.pcari.user.FollowerView;
import com.lyshnia.pcari.user.MessagesView;
import com.lyshnia.pcari.user.WishlistView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

public class QwInitListener implements VaadinServiceInitListener {
    @Override
    public void serviceInit(ServiceInitEvent initEvent) {
        final AccessControl accessControl = AccessControlFactory.getInstance()
                .createAccessControl();

        initEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
                if (!accessControl.isUserSignedIn() && (MessagesView.class
                        .equals(enterEvent.getNavigationTarget())
                        || FollowerView.class.equals(enterEvent.getNavigationTarget())
                        || WishlistView.class.equals(enterEvent.getNavigationTarget())
                ))
                    try {
                        MainView.get().launchLogin();
                    } catch (Exception ignored) {
                        UI.getCurrent().navigate(DashboardView.class);
                    }

            });
        });
    }
}
