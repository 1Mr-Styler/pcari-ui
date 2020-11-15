import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ProfileView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                  .shadow {
                  -webkit-box-shadow: 0px -6px 5px 2px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
                  -moz-box-shadow:    0px -6px 5px 2px #ccc;  /* Firefox 3.5 - 3.6 */
                  box-shadow:         0px -6px 5px 2px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; background-color: white;">
 <vaadin-vertical-layout theme="spacing" style="align-self: stretch; height: fit-content; align-items: center; flex-grow: 0;">
  <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;">
   <vaadin-button theme="icon contrast large tertiary" aria-label="Add new" id="closeButton">
    <iron-icon icon="lumo:cross"></iron-icon>
   </vaadin-button>
   <img style="margin-left: 20%; height: 45px;" src="images/logo.png">
  </vaadin-horizontal-layout>
  <img style="height: 100px; opacity: 0.75;" src="icons/user.png">
  <label style="font-size: 13px;">Joined [[n]]</label>
  <vaadin-horizontal-layout style="align-self: stretch; justify-content: space-around; padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m);">
   <vaadin-vertical-layout style="align-items: center;">
    <label style="margin: 0px; font-weight: bold;">25</label>
    <label>My Wishlist</label>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout style="align-items: center;">
    <label style="margin: 0px; font-weight: bold;">786</label>
    <label>Following</label>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="align-self: stretch; flex-grow: 1; border-radius: 15px 15px 0 0; z-index: 10; padding: var(--lumo-space-l); margin-top: var(--lumo-space-m); flex-shrink: 0; justify-content: flex-end;" class="shadow">
  <vaadin-text-field label="Enter your name" style="align-self: stretch; background-color: transparent;" has-value>
   <div slot="prefix">
    <iron-icon style="height: 20px;" icon="vaadin:user"></iron-icon>
   </div>
  </vaadin-text-field>
  <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-left: var(--lumo-space-l);">
   <iron-icon icon="vaadin:envelope"></iron-icon>
   <label style="flex-grow: 1;">jerrer@gmail.com</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-left: var(--lumo-space-l);">
   <iron-icon icon="vaadin:lock"></iron-icon>
   <label style="flex-grow: 1;">Change Password</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-left: var(--lumo-space-l);">
   <iron-icon icon="vaadin:qrcode"></iron-icon>
   <label style="flex-grow: 1;">QR Code</label>
  </vaadin-horizontal-layout>
  <vaadin-button style="align-self: center; margin-top: var(--lumo-space-xl);" theme="tertiary error" id="logoutButton">
    Sign Out 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'profile-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProfileView.is, ProfileView);
