import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class ProductLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                .header{
                    background: url("images/asx.jpg") no-repeat center;
                    background-size: cover;
                    position: fixed;
                    min-height: 350px;
                    width: 100%;
                    margin: 0;
                    padding: 0;
                    color: white;
                    text-align: center;
                    font-size: 16px;
                }
                
                .content{
                    width: 100%;
                    height: fit-content;
                    background-color: white;
                    margin: 0;
                    padding: 0;
                    margin-top: 350px;
                    position: absolute;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; margin-right: var(--lumo-space-m);" id="vaadinVerticalLayout">
 <vaadin-vertical-layout theme="spacing" class="header" style="justify-content: flex-end;" id="headerLayout">
  <vaadin-vertical-layout style="background-color: rgb(0, 0, 0, 0.5); height: 30%; padding: var(--lumo-space-m); align-self: stretch;">
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;">
    <label style="font-size: 20px">RM 19.8k</label>
    <label>Nissan Vanette 1.5</label>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;">
    <label>Manufactured: 2000</label>
    <label>Mileage: 195000 km</label>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; align-items: center;">
    <iron-icon icon="vaadin:envelope"></iron-icon>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" class="content clearfix" id="scrollingLayout">
  <vaadin-horizontal-layout theme="spacing" id="imgScroll" style="align-self: stretch; overflow-x: auto; height: fit-content; padding-top: var(--lumo-space-xs); padding-left: var(--lumo-space-xs);background-color: white;"></vaadin-horizontal-layout>
  <vaadin-tabs theme="equal-width-tabs primary" id="vaadinTabs" style="align-self: stretch;" orientation="horizontal" selected="0"></vaadin-tabs>
  <vaadin-vertical-layout theme="spacing-s" id="tabInfoLayout" style="width: 100%; padding: var(--lumo-space-s);">
   <label>[[title]]</label>
  </vaadin-vertical-layout>
  <vaadin-button style="align-self: stretch; border-radius: 8px; margin-right: var(--lumo-space-m); margin-left: var(--lumo-space-m);" theme="primary large">
   Contact Seller
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'product-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProductLayout.is, ProductLayout);
