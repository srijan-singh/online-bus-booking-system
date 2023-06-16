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

  async getBookings(userID : string){
    try {
      const data = await firstValueFrom(this.service.getBookingsByUserID(userID));
      this.bookings = data;
    } catch (error) {
      console.log('Error occurred during login:', error);
    }
  }

  async cancel(bookingID: number, userID: number) {
    var reason = prompt("Reason for cancellation", "");
  
    if (reason != null) {
      await this.service.cancelBooking(bookingID, reason.toString());
  
      setTimeout(async () => {
        await this.getBookings(String(userID));
        console.log(this.bookings);
      }, 2000);
    }
  }

  async review(bookingID: number, userID: number) {
    var rating = prompt("Please enter your rating (1-5)", "");
    var comment = prompt("Please enter your comment", "");
  
    if (rating != null && comment != null) {
      await this.service.reviewBooking(
        bookingID,
        rating.toString(),
        comment.toString()
      );
  
      setTimeout(async () => {
        await this.getBookings(String(userID));
        console.log(this.bookings);
      }, 2000);
    }
  }

  async getSchedule (scheduleID : number){
    try {
      const data = await firstValueFrom(this.scheduleService.getScheduleByID(scheduleID));
      
      this.schedule = data;

      setTimeout(async () => {

        await this.getRoute(this.schedule.routeID);

        var departure = new Date(this.schedule.departureTime);
        var arrival = new Date(this.schedule.arrivalTime);

        this.booking_information = 
        //Departure
        "Origin: "+this.bus_route.origin
        +"\nDeparture\nDate: "+departure.getDate()+"/"+departure.getMonth()+"/"+departure.getFullYear()
        +"\nTime: "+departure.getHours()+":"+departure.getMinutes()
        //Arrival
        +"\n\nDestination: "+this.bus_route.destination
        +"\nArrival\nDate: "+arrival.getDate()+"/"+arrival.getMonth()+"/"+arrival.getFullYear()
        +"\nTime: "+arrival.getHours()+":"+arrival.getMinutes()
        
        /* this.schedule_details = `
        <table class="table table-bordered text-center">
          <thead>
            <tr>
              <th colspan="2" class="gradient-header">Location</th>
              <th colspan="2" class="gradient-header">City</th>
              <th colspan="2" class="gradient-header">Date</th>
              <th colspan="2" class="gradient-header">Time</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="2"><b>Origin</b></td>
              <td colspan="2">${this.bus_route.origin}</td>
              <td colspan="2">${departure.getDate()}/${departure.getMonth()}/${departure.getFullYear()}</td>
              <td colspan="2">${departure.getHours()}:${departure.getMinutes()}:${departure.getSeconds()}</td>
            </tr>
            <tr>
              <td colspan="2"><b>Destination</b></td>
              <td colspan="2">${this.bus_route.destination}</td>
              <td colspan="2">${arrival.getDate()}/${arrival.getMonth()}/${arrival.getFullYear()}</td>
              <td colspan="2">${arrival.getHours()}:${arrival.getMinutes()}:${arrival.getSeconds()}</td>
            </tr>
          </tbody>
        </table>`;


        this.on(); */

        alert(this.booking_information)

      }, 100);

    } catch (error) {
      console.log('Error occurred during login:', error);
    }
    return this.schedule;
  }

  async getRoute(routeID : number){
    try {
      const data = await firstValueFrom(this.routeService.getRouteByID(routeID));
      
      this.bus_route = data;

    } catch (error) {
      console.log('Error occurred during login:', error);
    }
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
