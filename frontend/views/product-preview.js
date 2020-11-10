import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-board/src/vaadin-board-row.js';

class ProductPreview extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                }
                
                :hover {
                background:lightgray;
        box-shadow:inset -1px 0 0 darken(lightgray,10);
                }
            </style>
<vaadin-board-row style="height: 140px; width: 125px;  position: relative;
">
 <span style=" position: absolute; background-color: #294F75; color: white;">₦[[cost]]</span>
 <img style="height: 100px;" src="[[image]]" id="img">
 <span style="height: 40px; font-size: 12px; background-color: #E9EEEF;">[[name]]</span>
</vaadin-board-row>
`;
    }

    static get is() {
        return 'product-preview';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProductPreview.is, ProductPreview);
