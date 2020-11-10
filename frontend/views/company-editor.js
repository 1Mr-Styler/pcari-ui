import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-upload/src/vaadin-upload.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class CompanyEditor extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; padding: var(--lumo-space-m);">
 <vaadin-form-layout style="flex-grow: 1;">
  <vaadin-form-item>
   <label slot="label">Company Name</label>
   <vaadin-text-field label="" placeholder="Name" value="{{company.name}}"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item>
   <label slot="label">Tagline</label>
   <vaadin-text-field label="" placeholder="tagline" value="{{company.tagline}}"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item>
   <label slot="label">Address</label>
   <vaadin-text-field label="" placeholder="address" value="{{company.address}}"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item>
   <label slot="label">Website</label>
   <vaadin-text-field label="" placeholder="www.mycompany.ng" value="{{company.website}}"></vaadin-text-field>
  </vaadin-form-item>
  <vaadin-form-item colspan="2">
   <vaadin-upload id="upload"></vaadin-upload>
   <label slot="label">Logo</label>
  </vaadin-form-item>
  <vaadin-button on-click="update">
   <iron-icon icon="vaadin:check" slot="suffix" theme="primary success"></iron-icon>Update
  </vaadin-button>
 </vaadin-form-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'company-editor';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CompanyEditor.is, CompanyEditor);
