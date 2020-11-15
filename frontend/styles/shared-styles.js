// eagerly import theme styles so as we can override them
import '@vaadin/vaadin-lumo-styles/all-imports';

import '@vaadin/vaadin-charts/theme/vaadin-chart-default-theme';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>
    html {
      --lumo-primary-color: #26B9A4;
      --lumo-border-radius: calc(var(--lumo-size-m) / 2);
    }    
  </style>
</custom-style>


<custom-style>
  <style>
    html {
      overflow:hidden;
    }
    vaadin-app-layout vaadin-tab a:hover {
      text-decoration: none;
    }
    
    .v-loading-indicator::after {
      content: "";
      position: fixed; /* Occupy whole screen even if scrolled */
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      /* Eat mouse events when visible, doesn't prevent scrolling */
      pointer-events: auto;
      /* Animated with delay to prevent flashing */
      animation: fadein 0.3s ease-out 0.2s normal 1 both;
      z-index: 2147483647;
      cursor: wait;
    }
    
    .v-loading-indicator[style*=none]::after {
     display: none;
    }
  </style>
</custom-style>

<dom-module id="btn" theme-for="vaadin-button">
 <template>
   <style>
     [part="vaadin-login-submit"] {
         background-color: var(--lumo-contrast);
    }
   </style>
 </template>
</dom-module>


<dom-module id="overlay" theme-for="vaadin-dialog-overlay">
 <template>
   <style>
     /* Background needs a stronger selector to not be overridden */
    :host {
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            outline: 0px solid transparent;
    }
    
    [part="content"] {
       padding: 0px;
     }
   </style>
 </template>
</dom-module>

<dom-module id="my-grid-styles" theme-for="vaadin-grid">
 <template>
   <style>
     /* Background needs a stronger selector to not be overridden */
     [part~="cell"].success {
       background: green;
     }
     
     [part~="cell"].error {
       color: white;
       background: #DD4B39;
     }
     [part~="cell"].warning {
       color: white;
       background: #F29D12;
     }
   </style>
 </template>
</dom-module>

<dom-module id="chart" theme-for="vaadin-chart">
  <template>
    <style include="vaadin-chart-default-theme">
      :host {
        --vaadin-charts-color-0: var(--lumo-primary-color);
        --vaadin-charts-color-1: var(--lumo-error-color);
        --vaadin-charts-color-2: var(--lumo-success-color);
        --vaadin-charts-color-3: var(--lumo-contrast);
      }
      .highcharts-container {
        font-family: var(--lumo-font-family);
      }
      .highcharts-background {
        fill: var(--lumo-base-color);
      }
      .highcharts-title {
        fill: var(--lumo-header-text-color);
        font-size: var(--lumo-font-size-xl);
        font-weight: 600;
        line-height: var(--lumo-line-height-xs);
      }
      .highcharts-legend-item text {
        fill: var(--lumo-body-text-color);
      }
      .highcharts-axis-title,
      .highcharts-axis-labels {
        fill: var(--lumo-secondary-text-color);
      }
      .highcharts-axis-line,
      .highcharts-grid-line,
      .highcharts-tick {
        stroke: var(--lumo-contrast-10pct);
      }
      .highcharts-column-series rect.highcharts-point {
        stroke: var(--lumo-base-color);
      }
    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
