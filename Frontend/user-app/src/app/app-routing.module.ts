import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  // Authorization
  {path: 'login', component:LoginComponent},
  {path: 'register', component:RegistrationComponent},

  // Booking
  {path: 'dashboard', component:DashboardComponent},

  // Default
  {path: '**', redirectTo: '/listPortfolio', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
