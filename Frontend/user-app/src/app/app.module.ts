import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { BookingComponent } from './booking/booking.component';
import { LogoutComponent } from './logout/logout.component';
import { TicketComponent } from './ticket/ticket.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { ReviewComponent } from './review/review.component';
import { CancellationComponent } from './cancellation/cancellation.component';
import { PayComponent } from './pay/pay.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    DashboardComponent,
    BookingComponent,
    LogoutComponent,
    TicketComponent,
    PaymentComponent,
    PaymentGatewayComponent,
    ReviewComponent,
    CancellationComponent,
    PayComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule { }
