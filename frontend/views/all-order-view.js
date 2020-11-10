import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@polymer/iron-icon/iron-icon.js';

class AllOrderView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                }
            </style>
<vaadin-horizontal-layout theme="spacing" id="mainLayout" style="width: 100%; background-color: #DBDFE5; padding: var(--lumo-space-m);">
 <vaadin-combo-box id="orderStatusSelect" placeholder="Select Status"></vaadin-combo-box>
 <vaadin-button id="newOrderButton" theme="primary" on-click="newOrderButton">
  <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>New Order 
 </vaadin-button>
 <vaadin-horizontal-layout style="flex-grow: 1; align-items: center; justify-content: flex-end;" theme="spacing">
  <vaadin-button theme="tertiary" id="viewAllButton" on-click="viewAll">
    View All 
  </vaadin-button>
  <vaadin-date-picker label="" placeholder="Date From" id="fromDatePicker"></vaadin-date-picker>
  <vaadin-date-picker label="" placeholder="Date To" id="toDatePicker"></vaadin-date-picker>
  <vaadin-button theme="icon" aria-label="Add new" on-click="filter">
   <iron-icon icon="lumo:search"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'all-order-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AllOrderView.is, AllOrderView);
