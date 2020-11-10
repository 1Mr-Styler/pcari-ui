import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class HomeScreen extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; background-image:url(images/bg-03.png); padding-bottom: var(--lumo-space-xl);">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: flex-end; margin-top: var(--lumo-space-l); padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m);">
  <img style="height: 40px;" src="images/logo.png">
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; padding: var(--lumo-space-m);">
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 0; width: 50%; margin-top: var(--lumo-space-m);"></vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
   <img style="align-self: flex-end; width: 40px; height: 40px;" src="icons/user.png">
   <label style="align-self: flex-end; margin-top: 0px;font-weight:bold;">Hi User,</label>
   <label style="align-self: flex-end; margin-top: 0px;font-weight:bold;color: gray;">Welcome!</label>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; padding: var(--lumo-space-m); align-items: center; justify-content: flex-end;">
  <span style="font-weight: bold; color: white;">Unleash your Selling Potential with pcari.my</span>
  <img style="width: 70%;" src="images/car.png">
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; padding: var(--lumo-space-m); align-items: center; justify-content: flex-end;">
  <img style="width: 70%;" src="images/car2.png">
  <span style="font-weight: bold; color: black;">Say Hello to true vehicle browsing bliss</span>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="cardLayout" style="flex-grow: 1; align-items: center; justify-content: flex-end;"></vaadin-vertical-layout>
 <vaadin-button style="align-self: center;backgroud-color:white;" theme="primary contrast">
  Get started!
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'home-screen';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(HomeScreen.is, HomeScreen);
