import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserModuleComponent } from './user-module/user-module.component';
import { BookingModuleComponent } from './booking-module/booking-module.component';

@NgModule({
  declarations: [
    AppComponent,
    UserModuleComponent,
    BookingModuleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
