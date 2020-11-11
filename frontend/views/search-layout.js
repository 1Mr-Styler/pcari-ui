import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class SearchLayout extends PolymerElement {

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
 <vaadin-text-field placeholder="Search for [[cat]]" style="align-self: stretch; padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m); padding-top: var(--lumo-space-l);">
  <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
 </vaadin-text-field>
 <h2 style="padding-left: var(--lumo-space-m); margin-top: var(--lumo-space-l); margin-bottom: 0px;">[[cat]] </h2>
 <span style="align-self: stretch; padding-left: var(--lumo-space-m); font-size:13px;color: gray;">Choose [[cat]] Type That You Are Looking For</span>
 <vaadin-vertical-layout theme="spacing-xs" id="nonServiceLayout" style="width: 100%; padding: var(--lumo-space-l); align-items: center;">
  <vaadin-select id="brandSelect" style="align-self: stretch;" placeholder="[[cat]] Make / Brands"></vaadin-select>
  <vaadin-select id="modelsSelect" style="align-self: stretch;" placeholder="Models"></vaadin-select>
  <vaadin-select id="variantsSelect" style="align-self: stretch;" placeholder="Variants"></vaadin-select>
  <vaadin-button id="searchButton" class="anime" style="align-self: stretch; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); margin-top: var(--lumo-space-m);" theme="primary">
   Search
  </vaadin-button>
  <vaadin-button theme="tertiary">
   Advanced Search
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'search-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SearchLayout.is, SearchLayout);
