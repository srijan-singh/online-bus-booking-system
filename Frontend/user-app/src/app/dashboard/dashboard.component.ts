import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/Booking';
import { Schedule } from '../model/Schedule';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { BookingService } from '../service/booking.service';
import { firstValueFrom, timeInterval } from 'rxjs';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{

  userId: string = "";

  users : User[] = []
  
  bookings : Booking[] = []

  schedule : Schedule = new Schedule()

  constructor(private service : BookingService, private route : Router){
    //this.users = this.service.listUsers();
  }
  
  async ngOnInit() {
    var userID = localStorage.getItem('userID');

    if(userID !== null){
      this.userId = userID;

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

    if(reason != null){
      await this.service.cancelBooking(bookingID, reason.toString());    
 
      await this.getBookings(String(userID));
    
      console.log(this.bookings); 
    }
  }

  async review(bookingID: number, userID : number){
    
    var rating = prompt("Please enter your rating (1-5)", "");

    var comment = prompt("Please enter your comment", "");

    if(rating != null && comment != null){
      
      await this.service.reviewBooking(bookingID, rating.toString(), comment.toString());

      await this.getBookings(String(userID));

      console.log(this.bookings); 
    }
  }

  logout(){
    localStorage.removeItem('userID');

    this.route.navigate(['/login'])
  }

}
