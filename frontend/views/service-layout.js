import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';

class ServiceLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                .shadow {
                  -webkit-box-shadow: 3px 3px 5px 2px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
                  -moz-box-shadow:    3px 3px 5px 2px #ccc;  /* Firefox 3.5 - 3.6 */
                  box-shadow:         3px 3px 5px 2px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center;">
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
 <vaadin-horizontal-layout theme="" id="servicesLayout" style="margin-top: var(--lumo-space-xl); width: 100%; align-items: center; justify-content: space-between; padding-right: var(--lumo-space-xl); padding-left: var(--lumo-space-xl);">
  <vaadin-button theme="icon" aria-label="Car" style="height: 70px; width: 70px;" id="carButton" class="shadow">
   <iron-icon icon="vaadin:car" style="width: 100%; height: 100%;"></iron-icon>
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Bike" style="height: 70px; width: 70px;" id="bikeButton" class="shadow">
   <iron-icon src="icons/motorcycle.svg" style="width: 100%; height: 100%; color: #2b81af" id="ironIcon"></iron-icon>
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Truck" style="height: 70px; width: 70px;" id="truckButton" class="shadow">
   <iron-icon icon="vaadin:truck" style="width: 100%; height: 100%;"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <label style="padding-right: var(--lumo-space-xl); padding-left: var(--lumo-space-xl); margin-top: var(--lumo-space-l);">Browse Businesses by Category</label>
 <vaadin-horizontal-layout style="align-items: center; justify-content: space-between; padding-left: var(--lumo-space-xl); padding-right: var(--lumo-space-xl); align-self: stretch; margin-right: var(--lumo-space-l); margin-left: var(--lumo-space-l); margin: var(--lumo-space-m);">
  <vaadin-button theme="icon" aria-label="Add new" id="bodyButton" class="shadow" style="width: 100px; height: 100px;">
   <iron-icon style="width: 100%; height: 100%;" src="icons/body-paint-repair.svg"></iron-icon>
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="towingButton" class="shadow" style="height: 100px; width: 100px;">
   <iron-icon style="width: 100%; height: 100%;" src="icons/tow.svg"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="align-items: center; justify-content: space-between; padding-left: var(--lumo-space-xl); padding-right: var(--lumo-space-xl); align-self: stretch; margin-right: var(--lumo-space-l); margin-left: var(--lumo-space-l); margin: var(--lumo-space-m);">
  <vaadin-button theme="icon" aria-label="Add new" style="width: 100px; height: 100px;" id="washButton" class="shadow">
   <iron-icon style="width: 100%; height: 100%;" src="icons/car-wash.svg"></iron-icon>
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" style="height: 100px; width: 100px;" id="servicesButton" class="shadow">
   <iron-icon style="width: 100%; height: 100%;" src="icons/maintenance.svg"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-select style="margin-left: var(--lumo-space-l); margin-right: var(--lumo-space-l); align-self: stretch; margin-top: var(--lumo-space-m);" placeholder="Select State"></vaadin-select>
 <vaadin-combo-box style="margin-left: var(--lumo-space-l); margin-right: var(--lumo-space-l); align-self: stretch; margin-top: var(--lumo-space-xs);" theme="large" placeholder="Select City" clear-button-visible></vaadin-combo-box>
 <vaadin-button id="searchButton" class="shadow" style="margin-top: var(--lumo-space-l); height: 45px; width: 60vw;" theme="primary">
  Search
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'service-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ServiceLayout.is, ServiceLayout);
