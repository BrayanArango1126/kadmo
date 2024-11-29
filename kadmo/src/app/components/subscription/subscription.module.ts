import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubscriptionRoutingModule } from './subscription-routing.module';
import { SubscriptionComponent } from './subscription.component';
import { AboutSubscriptionComponent } from './pages/about-subscription/about-subscription.component';
import { SharedModule } from '../shared/shared.module';
import { BenefitsComponent } from './pages/benefits/benefits.component';
import { SubscriptionOptionsComponent } from './pages/subscription-options/subscription-options.component';


@NgModule({
  declarations: [
    SubscriptionComponent,
    AboutSubscriptionComponent,
    BenefitsComponent,
    SubscriptionOptionsComponent
  ],
  imports: [
    CommonModule,
    SubscriptionRoutingModule,
    SharedModule
  ]
})
export class SubscriptionModule { }
