import { Injectable } from '@angular/core';
import { BookingAPI } from './API';
import { HttpClient } from '@angular/common/http';
import { Booking } from '../model/Booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  bookings : Booking[] = []

  bookingAPI : BookingAPI = new BookingAPI();

  constructor(private http : HttpClient){}

  getBookingsByUserID(userID : string){
    return this.http.get<Booking []>(this.bookingAPI.getBookingbyUserID(userID));
  }

  async cancelBooking(bookingID : number, reason : string){
    console.log(this.bookingAPI.cancelBooking(bookingID));
     return this.http.post<Number>(this.bookingAPI.cancelBooking(bookingID), {
      "reason" : reason,
    }).subscribe(booking=>{
      console.log(booking);
    });
  }

  async reviewBooking(bookingID : number, rating : string, comment : string){
    console.log(this.bookingAPI.reviewBooking(bookingID));
    return this.http.post<Booking>(this.bookingAPI.reviewBooking(bookingID), {
      "rating": rating,
      "comment" : comment,
    }).subscribe(booking=>{
      console.log(booking);
    });
  }
  
}
