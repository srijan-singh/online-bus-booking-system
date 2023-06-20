import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit{

  paymentID : number = 0;

  bookingID : number = 0;

  amount : number = 0;

  message : string = "";

  constructor(private route : Router){}


  ngOnInit(): void {

    this.paymentID = Number(localStorage.getItem('paymentID'));
    this.bookingID = Number(localStorage.getItem('bookingID'));
    this.amount = Number(localStorage.getItem('amount'));

    this.message = "Booking Successfull!\nBooking ID: "+this.bookingID
    +"\nPayment ID: "+this.paymentID;

  }

  payment(){
    
    alert("You will be redirected to Payment Gateway!");
    
    localStorage.removeItem('payment');
    localStorage.removeItem('bookingID');
    localStorage.removeItem('amount');

    localStorage.setItem("message", this.message);

    this.route.navigate(['/pay'])
  }

}
