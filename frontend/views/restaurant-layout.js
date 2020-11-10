import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class RestaurantLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-split-layout class="content" style="width: 100%; padding: var(--lumo-space-l); height: 95%;">
 <vaadin-vertical-layout theme="spacing">
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; padding: var(--lumo-space-s);">
   <vaadin-button id="dineInButton" style="flex-grow: 1; flex-shrink: 1;" tabindex="1" theme="contrast">
    <iron-icon icon="lumo:edit" slot="prefix"></iron-icon>Dine In 
   </vaadin-button>
   <vaadin-button id="takeAwayButton" style="flex-grow: 1;" tabindex="2" theme="contrast">
    <iron-icon icon="vaadin:briefcase" slot="prefix"></iron-icon>Take Away 
   </vaadin-button>
   <vaadin-button id="deliveryButton" style="flex-grow: 1;" tabindex="3" theme="contrast">
    <iron-icon icon="vaadin:car" slot="prefix"></iron-icon>Delivery 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; justify-content: space-between; padding: var(--lumo-space-s);">
   <vaadin-combo-box id="waiterCombo" style="flex-grow: 0;" placeholder="Select Waiter"></vaadin-combo-box>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-combo-box id="customerCombo" style="flex-grow: 0;" placeholder="Select Customer"></vaadin-combo-box>
    <vaadin-button theme="icon" aria-label="Add new" id="addCustomerButton">
     <iron-icon icon="lumo:plus"></iron-icon>
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-button id="selectTableButton" theme="contrast">
    <iron-icon icon="vaadin:table" slot="prefix"></iron-icon>Table 
   </vaadin-button>
   <vaadin-button theme="contrast" id="heldOrders" on-click="recoverOrders">
    <iron-icon icon="vaadin:edit" slot="prefix"></iron-icon>Orders 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout id="oqHolder" style="background-color: white; flex-grow: 1; height: 100%; width: 100%;">
   <vaadin-horizontal-layout style="align-self: stretch; align-items: center;" theme="spacing-xl">
    <label style="font-weight: bold;">SubTotal: ₦[[subTotal]]</label>
    <label>Tax: 0%</label>
    <vaadin-integer-field id="discountTextFeild" style="width: 100px;" placeholder="Discount" has-value>
     <div slot="prefix">
       ₦ 
     </div>
    </vaadin-integer-field>
    <vaadin-integer-field id="chargeTextField" style="width: 100px;" placeholder="Charges" has-value>
     <div slot="prefix">
       ₦ 
     </div>
    </vaadin-integer-field>
    <label style="font-weight: bold; color: #60BE74;">Total: ₦[[total]]</label>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout style="flex-grow: 3; padding: var(--lumo-space-s); background-color: white; flex-shrink: 4; max-width:750px;" theme="spacing">
  <vaadin-text-field placeholder="Item Name/Barcode" style="flex-grow: 0; align-self: stretch;" id="searchField">
   <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
  </vaadin-text-field>
  <vaadin-board id="searchPreview" style="overflow: auto;"></vaadin-board>
 </vaadin-vertical-layout>
</vaadin-split-layout>
`;
    }

    static get is() {
        return 'restaurant-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(RestaurantLayout.is, RestaurantLayout);
