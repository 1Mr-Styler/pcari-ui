import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-board/src/vaadin-board.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class PosView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-split-layout class="content" style="width: 100%; padding: var(--lumo-space-l); height: 95%;">
 <vaadin-vertical-layout style="flex-grow: 3; padding: var(--lumo-space-s); background-color: white; flex-shrink: 4; max-width:750px;" theme="spacing">
  <vaadin-text-field placeholder="Product Name/Barcode" style="flex-grow: 0; align-self: stretch;" id="searchField">
   <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
  </vaadin-text-field>
  <vaadin-board id="searchPreview" style="overflow: auto;"></vaadin-board>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout style="flex-grow: 5; flex-shrink: 3;" theme="spacing">
  <vaadin-horizontal-layout style="align-self: stretch; background-color: white; padding: var(--lumo-space-s);">
   <vaadin-combo-box style="flex-grow: 1;" placeholder="Select Customer"></vaadin-combo-box>
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout id="oqHolder" style="background-color: white; flex-grow: 1; height: 100%;">
   <vaadin-horizontal-layout style="align-self: stretch;" theme="spacing-xl">
    <label style="font-weight: bold;">SubTotal: ₦[[subTotal]]</label>
    <label>Tax: 0%</label>
    <label style="font-weight: bold; color: #60BE74;">Total: ₦[[total]]</label>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-split-layout>
`;
    }

    static get is() {
        return 'pos-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(PosView.is, PosView);
