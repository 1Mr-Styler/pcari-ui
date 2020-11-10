import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class ReceiptView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                label, .my-grid {
   font-size: smaller;
   border: 0px;
}

p {
font-size: small;
}


      [part~="cell"] ::slotted(vaadin-grid-cell-content), vaadin-grid-cell-content {
        padding: 0;
        white-space:normal;
      }
    
            </style>
<vaadin-vertical-layout style="width: 360px; height: 100%;">
 <vaadin-horizontal-layout style="width: 100%; justify-content: center; padding: var(--lumo-space-m);">
  <img style="width: 100px;" src="[[company.logo]]" id="img">
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: center;">
  <h3 style="margin: 3px;">[[company.name]]</h3>
 </vaadin-horizontal-layout>
 <h6 style="align-self: center; margin: 0px;">[[company.tagline]]</h6>
 <p style="align-self: center; margin: 3px;">[[branch.address]], [[location]]</p>
 <p style="align-self: center; margin: 0px;">Phone: [[branch.phone]] | Email: [[branch.email]]</p>
 <hr style="width: 100%; opacity: 0.4;">
 <p style="padding-right: var(--lumo-space-l); padding-left: var(--lumo-space-l); margin: 1px;">Invoice #[[booking.orderNumber]]</p>
 <p style="padding-right: var(--lumo-space-l); padding-left: var(--lumo-space-l); margin: 0px;">[[lastUpdated]]</p>
 <p style="padding-right: var(--lumo-space-l); padding-left: var(--lumo-space-l); margin: 1px;">Prepared by [[cashier]]</p>
 <hr style="width: 100%; opacity: 0.4;">
 <vaadin-vertical-layout id="gridLayout" style="width: 100%; padding: 0px;"></vaadin-vertical-layout>
 <p style="align-self: flex-end; padding-right: var(--lumo-space-l); margin: 2px;font-weight:bold;">Total: ₦[[total]]</p>
 <p style="align-self: flex-end; padding-right: var(--lumo-space-l); margin: 0px;">Paid: ₦[[paid]]</p>
 <p style="align-self: flex-end; padding-right: var(--lumo-space-l); margin: 0px;">Change: ₦[[change]]</p>
 <p style="align-self: center; margin: 5px; margin-bottom: 0px;">No return of goods after purchase.</p>
 <p style="align-self: center; margin-top: 5px;">Thanks for your patronage.</p>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'receipt-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ReceiptView.is, ReceiptView);
