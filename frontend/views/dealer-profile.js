import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class DealerProfile extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; margin-top: var(--lumo-space-l); align-items: center; padding-right: var(--lumo-space-s); padding-left: var(--lumo-space-s);">
  <vaadin-button theme="icon tertiary" aria-label="" id="backButton">
   <iron-icon icon="lumo:arrow-left"></iron-icon>
  </vaadin-button>
  <img style="height: 40px; flex-grow: 0; flex-shrink: 1; margin-left: 24%;" src="images/logo.png">
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; padding: var(--lumo-space-m); align-items: center;">
  <img style="width: 100px; height: 100px; border-radius: 50%;" src="[[logo]]">
  <vaadin-vertical-layout style="flex-grow: 1; padding: 0px; align-self: stretch; padding-top: var(--lumo-space-s);">
   <h3 style="margin: 0px;">[[dealer]] </h3>
   <label style="font-size: 14px;">[[n]] total posts</label>
   <label style="font-size: 14px;">[[location]]</label>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="padding-left: var(--lumo-space-m); align-items: center;">
  <vaadin-button style="color: black;" theme="tertiary">
    Sort 
  </vaadin-button>
  <span>|</span>
  <vaadin-button style="color: black;" theme="tertiary">
    Filter 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing-xs" id="resultHolder" style="width: 100%; overflow: auto;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'dealer-profile';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DealerProfile.is, DealerProfile);
