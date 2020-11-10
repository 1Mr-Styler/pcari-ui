import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';

class CheckoutView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 700px;" theme="spacing-xl">
 <vaadin-vertical-layout style="flex-grow: 2;" theme="spacing">
  <vaadin-text-field label="Amount" value="" id="amountCash" style="flex-grow: 0; flex-shrink: 1; width: 100%;" has-value>
   <div slot="prefix">
     ₦ 
   </div>
  </vaadin-text-field>
  <vaadin-horizontal-layout style="width: 100%; background-color: #EFF2FD; padding: var(--lumo-space-m);" theme="spacing" id="hl1">
   <vaadin-text-field label="Amount" id="amountMulti1" style="flex-grow: 1; flex-shrink: 1; width: 100%;" has-value>
    <div slot="prefix">
      ₦ 
    </div>
   </vaadin-text-field>
   <vaadin-select label="Method" id="method1"></vaadin-select>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="width: 100%; background-color: #EFF2FD; padding: var(--lumo-space-m);" theme="spacing" id="hl2">
   <vaadin-text-field label="Amount" value="" id="amountMulti2" style="flex-grow: 1; flex-shrink: 1; width: 100%;" has-value>
    <div slot="prefix">
      ₦ 
    </div>
   </vaadin-text-field>
   <vaadin-select value="Item one" label="Method" id="method2"></vaadin-select>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout style="flex-grow: 1;" theme="spacing-xs">
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #0173B7; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Total Items:</label>
   <label style="font-weight: bold;">[[totalItems]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #0173B7; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Total Cost:</label>
   <label style="font-weight: bold;">₦[[totalCost]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #0173B7; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Discount:</label>
   <label style="font-weight: bold;">₦[[discount]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #00A65A; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Total Payable:</label>
   <label style="font-weight: bold;">₦[[payable]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #0173B7; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Total Paid:</label>
   <label style="font-weight: bold;">₦[[paid]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #0173B7; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Balance:</label>
   <label style="font-weight: bold;">₦[[balance]]</label>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout style="justify-content: space-between; width: 100%; background-color: #FF851A; height: 50px; align-items: center; padding: var(--lumo-space-m); color: white;">
   <label>Change:</label>
   <label style="font-weight: bold;">₦[[change]]</label>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
<hr style="width: 100%;">
<vaadin-horizontal-layout style="width: 700px; justify-content: flex-end;" theme="spacing">
 <vaadin-button id="closeButton">
   Close 
 </vaadin-button>
 <vaadin-button theme="primary success" on-click="saveAndPrint">
   Save &amp; Print 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'checkout-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CheckoutView.is, CheckoutView);
