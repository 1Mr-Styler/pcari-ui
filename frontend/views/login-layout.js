import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-login/src/vaadin-login-form.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class LoginLayout extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
                
                .holder1 {
                    border-radius:  0 0 15px 15px;
                    background-color: #26B9A4;
                    z-index: 10;
                }
                .logo {
                    width: 60vw;
                    position:relative;
                    top: 95px;
                }
                .car {
                    width: 60vw;
                    position:relative;
                    top: 135px;
                    animation-name: example;
                    animation-duration: 4s;
                }
                
                .man {
                    width: 20vw;
                    position: relative;
                    top: -2px;
                    left: 77px;
                    animation-name: man;
                    animation-duration: 4s;
                }
                
                @keyframes example {
                  0%   {left:200px;}
                  50% {left:0px; }
                }
                @keyframes man {
                  0%   {opacity:0%;}
                  100% {opacity: 100%; }
                }
                
                .holder2 {
                    background-color: white;
                }
                
                .shadow {
                  -webkit-box-shadow: 3px 3px 5px 2px #ccc;  /* Safari 3-4, iOS 4.0.2 - 4.2, Android 2.3+ */
                  -moz-box-shadow:    3px 3px 5px 2px #ccc;  /* Firefox 3.5 - 3.6 */
                  box-shadow:         3px 3px 5px 2px #ccc;  /* Opera 10.5, IE 9, Firefox 4+, Chrome 6+, iOS 5 */
                }
            </style>
<vaadin-vertical-layout style="width: 100%;">
 <vaadin-vertical-layout theme="spacing" id="holder1" class="holder1 shadow" style="height: 31vh; align-self: stretch; align-items: center; justify-content: center;">
  <img src="images/logo-i.png" class="logo">
  <img class="car" src="images/car.png">
  <img class="man" src="images/man.png">
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="holder2" class="holder2" style="align-self: stretch; flex-grow: 1; justify-content: center; align-items: center; height: 69vh;">
  <vaadin-login-form id="loginForm" style="margin-bottom: 0px; padding-bottom: 0px;"></vaadin-login-form>
  <vaadin-vertical-layout id="registerForm" style="align-self: stretch; padding: var(--lumo-space-l);">
   <h3 style="margin: 0px;">Register </h3>
   <vaadin-text-field label="Names" id="namesField" style="width: 100%;" required></vaadin-text-field>
   <vaadin-text-field label="Email" id="emailField" style="width: 100%;" required clear-button-visible prevent-invalid-input></vaadin-text-field>
   <vaadin-password-field label="Password" id="passwordField" style="width: 100%;" required has-value></vaadin-password-field>
   <vaadin-button id="regSubmitButton" style="align-self: stretch; margin-top: var(--lumo-space-l);" theme="primary contained">
     Button 
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout style="align-self: stretch; margin: 0px; align-items: center; justify-content: center;">
   <span id="infoSpan">Don't have an account? </span>
   <vaadin-button id="registerButton" theme="tertiary">
    Register here
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
<vaadin-button theme="icon contrast large" aria-label="Add new" id="closeButton" style="
    top: 0px;
    position: absolute;
    z-index: 10;
">
 <iron-icon icon="lumo:cross"></iron-icon>
</vaadin-button>
`;
    }

    static get is() {
        return 'login-layout';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginLayout.is, LoginLayout);
