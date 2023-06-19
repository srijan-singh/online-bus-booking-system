import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookingComponent } from './booking/booking.component';
import { TicketComponent } from './ticket/ticket.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentGatewayComponent } from './payment-gateway/payment-gateway.component';
import { ReviewComponent } from './review/review.component';
import { CancellationComponent } from './cancellation/cancellation.component';

const routes: Routes = [
  
  // Authorization
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegistrationComponent},

  // Dashboard
  {path: 'dashboard', component:DashboardComponent},

  // Booking
  {path : 'booking', component:BookingComponent},

  // Ticket
  {path: 'ticket', component:TicketComponent},

  // Payment
  {path: 'payment', component:PaymentComponent},
  {path: 'payment-gateway', component:PaymentGatewayComponent},

  // Review
  {path: 'review', component:ReviewComponent},

  // Cancellation
  {path: 'cancellation', component:CancellationComponent},

  // Default
  {path: '**', redirectTo: '/login', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
