import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookingComponent } from './booking/booking.component';

const routes: Routes = [
  // Authorization
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegistrationComponent},

  // Dashboard
  {path: 'dashboard', component:DashboardComponent},

  // Booking
  {path : 'booking', component:BookingComponent},

  // Default
  {path: '**', redirectTo: '/login', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
