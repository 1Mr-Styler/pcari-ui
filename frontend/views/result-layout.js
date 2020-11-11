import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ResultLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; background-color: white;">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; margin-top: var(--lumo-space-l); align-items: center; padding-right: var(--lumo-space-s); padding-left: var(--lumo-space-s);">
  <vaadin-button theme="icon tertiary" aria-label="" id="backButton">
   <iron-icon icon="lumo:arrow-left"></iron-icon>
  </vaadin-button>
  <img style="height: 40px; flex-grow: 0; flex-shrink: 1; margin-left: 24%;" src="images/logo.png">
 </vaadin-horizontal-layout>
 <h2 style="padding-left: var(--lumo-space-m); margin-top: var(--lumo-space-l); margin-bottom: 0px;">[[cat]] Lists</h2>
 <span style="align-self: stretch; padding-left: var(--lumo-space-m); font-size:13px;color: gray;">Search Results</span>
 <vaadin-horizontal-layout theme="spacing" id="filterLayout" style="width: 100%; padding-left: var(--lumo-space-m); padding-top: var(--lumo-space-l);">
  <vaadin-button id="allButton" style="font-size: small;">
   All
  </vaadin-button>
  <vaadin-button id="newButton" style="font-size: small;">
   New
  </vaadin-button>
  <vaadin-button id="usedButton" style="font-size: small;">
   Used
  </vaadin-button>
  <vaadin-button id="reconButton" style="font-size: small;">
   Recon
  </vaadin-button>
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
        return 'result-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ResultLayout.is, ResultLayout);
