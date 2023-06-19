import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/Booking';
import { Schedule } from '../model/Schedule';
import { Router } from '@angular/router';
import { BookingService } from '../service/booking.service';
import { firstValueFrom} from 'rxjs';
import { Route } from '../model/Route';
import { ScheduleService } from '../service/schedule.service';
import { RouteService } from '../service/route.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{

  userId: string = "";

  userName : string = "";
  
  bookings : Booking[] = []

  schedule : Schedule = new Schedule();

  bus_route : Route = new Route()

  booking_information : string = "";

  schedule_details : string = "";

  constructor(private service : BookingService, private scheduleService: ScheduleService, private routeService : RouteService, private route : Router){
    //this.users = this.service.listUsers();
  }
  
  async ngOnInit() {
    var userID = localStorage.getItem('userID');

    var userName = localStorage.getItem('userName');

    if(userID !== null){
      this.userId = userID;

      this.userName = userName !== null ? userName : "User";

      await this.getBookings(userID);

      console.log(this.bookings);
    }
    
  }

  makeBooking(){
    this.route.navigate(['/booking']);
  }

  async getBookings(userID : string){
    try {
      const data = await firstValueFrom(this.service.getBookingsByUserID(userID));
      this.bookings = data;
    } catch (error) {
      console.log('Error occurred during login:', error);
    }
  }

  async cancel(bookingID: number) {
    localStorage.setItem('bookingID', String(bookingID));
    this.route.navigate(['/cancellation']);
  }

  review(bookingID: number) {
    localStorage.setItem('bookingID', String(bookingID));
    this.route.navigate(['/review']);
  }

  // Route

  getTicket (scheduleID : number, bookingID : number, seatNumber: number){

    localStorage.setItem("scheduleID", String(scheduleID));

    localStorage.setItem('bookingID', String(bookingID));

    localStorage.setItem('seatNumber', String(seatNumber));

    this.route.navigate(['/ticket'])
  }

  logout(){
    localStorage.removeItem('userID');

    this.route.navigate(['/login'])
  }

  //Overlay

  on() {
    const overlayElement = document.getElementById("overlay");
    if (overlayElement) {
      overlayElement.style.display = "block";
    }
  }
  
  off() {
    const overlayElement = document.getElementById("overlay");
    if (overlayElement) {
      overlayElement.style.display = "none";
    }
  }
  
}
