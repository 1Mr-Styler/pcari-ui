import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class DashboardView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; margin-top: var(--lumo-space-l); align-items: center; padding-right: var(--lumo-space-s); padding-left: var(--lumo-space-s);">
  <img style="align-self: flex-end; width: 40px; height: 40px;" src="icons/user.png">
  <img style="height: 40px; flex-grow: 0; flex-shrink: 1; margin-left: 24%;" src="images/logo.png">
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 100%; margin-top: var(--lumo-space-s); padding-left: var(--lumo-space-s); padding-right: var(--lumo-space-s);">
  <vaadin-horizontal-layout theme="spacing-xs" style="width: 100%;  font-size: x-large;">
   <label>Hello, </label>
   <label style="font-weight: bold;">User!</label>
  </vaadin-horizontal-layout>
  <label style="color: gray; margin-top: 0px;">Good Morning, welcome back.</label>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing-s" id="servicesLayout" style="margin-top: var(--lumo-space-xl); align-self: stretch;"></vaadin-horizontal-layout>
 <label style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-s);">Featured Post</label>
 <vaadin-horizontal-layout theme="spacing-s" id="fpostLayout" style="width: 100%; margin-right: var(--lumo-space-xs); overflow: auto;"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="align-items: center; justify-content: space-between; margin-left: var(--lumo-space-s); width: 100%; margin-right: var(--lumo-space-xs); margin-top: var(--lumo-space-m); padding-right: var(--lumo-space-m);">
  <label style="margin: 0px;">Featured Dealers</label>
  <a href="#" style="text-decoration: none; color: var(--lumo-primary-color);">See All</a>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing-s" id="fdealersLayout" style="width: 100%; margin-right: var(--lumo-space-xs); overflow: auto; margin-left: var(--lumo-space-m); height: 200px;"></vaadin-horizontal-layout>
 <label style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-s);">Fast Deal</label>
 <vaadin-horizontal-layout theme="spacing-s" id="fdealLayout" style="width: 100%; margin-right: var(--lumo-space-xs); overflow: auto;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'dashboard-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DashboardView.is, DashboardView);
