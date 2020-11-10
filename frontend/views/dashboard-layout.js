import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-board/src/vaadin-board.js';
import '@vaadin/vaadin-board/src/vaadin-board-row.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class DashboardLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                .create {
                    margin: 10px;
                    background-color: white;
                }
                
                .create button {
                    color: white;
                    background-color: #2b81af;
                }
                
                @media (max-width: 800px) {
                .nofone {
                display: none;
                }
                }
            </style>
<vaadin-board style="width: 100%; height: 100%;">
 <vaadin-board-row>
  <vaadin-board-row style="flex-grow: 0; max-width: 404px;">
   <vaadin-vertical-layout theme="spacing" style="flex-shrink: 0; flex-grow: 1; align-items: center; background-color: white; margin: var(--lumo-space-s);">
    <vaadin-combo-box id="branchCombo" style="padding-right: var(--lumo-space-m); padding-left: var(--lumo-space-m); align-self: stretch;" label="Branch"></vaadin-combo-box>
    <vaadin-horizontal-layout style="background-color: #192434; width: 100%; align-items: center; justify-content: center; height: 40px; border-radius: 15px;">
     <h3 style="color: white; margin: 0px;">PRODUCTS</h3>
    </vaadin-horizontal-layout>
    <label>Total in Warehouse: [[tiw]]</label>
    <label>Total on Shelves: [[tos]]</label>
    <label>Total Sold: [[tosd]]</label>
    <vaadin-button theme="primary contrast" id="manageStockButton">
      Manage Stock Locations 
    </vaadin-button>
    <vaadin-button theme="primary contrast" id="newBatchButton">
      New Batch 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-board-row>
  <vaadin-board-row style="flex-shrink: 0;" class="nofone">
   <vaadin-vertical-layout theme="spacing" class="create" style="align-items: center;">
    <label>Total Suppliers</label>
    <span style="font-weight: bold; font-size: xx-large;">[[suppliers]]</span>
    <vaadin-button style="align-self: stretch;" theme="primary contrast" id="suppliers">
      Manage Supplier 
    </vaadin-button>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="create" style="align-items: center;">
    <label>Total product category</label>
    <span style="font-weight: bold; font-size: xx-large;">[[tpc]]</span>
    <vaadin-button style="align-self: stretch;" theme="primary contrast" id="category">
      Manage Category 
    </vaadin-button>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="create" style="align-items: center;">
    <label>Total Brands</label>
    <span style="font-weight: bold; font-size: xx-large;">[[brands]]</span>
    <vaadin-button style="align-self: stretch;" theme="primary contrast" id="brands">
      Manage Brand 
    </vaadin-button>
   </vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" class="create" style="align-items: center;">
    <label>Total products</label>
    <span style="font-weight: bold; font-size: xx-large;">[[products]]</span>
    <vaadin-button style="align-self: stretch;" theme="primary contrast" id="products">
      Manage Product 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-board-row>
 </vaadin-board-row>
 <vaadin-board-row>
  <vaadin-board-row style="margin: var(--lumo-space-s);">
   <vaadin-horizontal-layout style="flex-grow: 1;">
    <div style="width: 90px; height: 90px; display: flex; align-items: center; justify-content: center; background-color: #00A65A;">
     <img style="width: 40px;" src="icons/naira.png">
    </div>
    <vaadin-vertical-layout theme="spacing-xs" style="background-color: white; flex-grow: 1; padding: var(--lumo-space-xs); margin-right: var(--lumo-space-m);">
     <label>TOTAL SALES TODAY</label>
     <span style="font-weight: bold;">₦[[tst]]</span>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="flex-grow: 1;">
    <div style="width: 90px; height: 90px; display: flex; align-items: center; justify-content: center; background-color: #04C0EF;">
     <img style="width: 40px;" src="icons/cart.png">
    </div>
    <vaadin-vertical-layout theme="spacing-xs" style="background-color: white; flex-grow: 1; padding: var(--lumo-space-xs); margin-right: var(--lumo-space-m);">
     <label>TOTAL PRODUCTS SOLD TODAY</label>
     <span style="font-weight: bold; align-self: center;">[[tpst]]</span>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="flex-grow: 1;">
    <div style="width: 90px; height: 90px; display: flex; align-items: center; justify-content: center; background-color: #F29D12;">
     <img style="width: 40px;" src="icons/naira.png">
    </div>
    <vaadin-vertical-layout theme="spacing-xs" style="background-color: white; flex-grow: 1; padding: var(--lumo-space-xs); margin-right: var(--lumo-space-m);">
     <label>TOTAL EXPENSES DUE</label>
     <span style="font-weight: bold;">₦[[ted]]</span>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout style="flex-grow: 0;">
    <div style="width: 90px; height: 90px; display: flex; align-items: center; justify-content: center; background-color: #DD4B39;">
     <img style="width: 40px;" src="icons/naira.png">
    </div>
    <vaadin-vertical-layout theme="spacing-xs" style="background-color: white; flex-grow: 1; padding: var(--lumo-space-xs);">
     <label>TOTAL EXPENSES TODAY</label>
     <span style="font-weight: bold;">₦[[tett]]</span>
    </vaadin-vertical-layout>
   </vaadin-horizontal-layout>
  </vaadin-board-row>
 </vaadin-board-row>
 <vaadin-board-row style="margin: var(--lumo-space-s); height: 100%;">
  <vaadin-horizontal-layout theme="spacing" id="gridLayout" style="width: 100%; height: 100%;"></vaadin-horizontal-layout>
 </vaadin-board-row>
</vaadin-board>
`;
    }

    static get is() {
        return 'dashboard-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(DashboardLayout.is, DashboardLayout);
