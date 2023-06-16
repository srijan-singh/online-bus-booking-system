import { Injectable } from '@angular/core';
import { Payment } from '../model/Payment';
import { PaymentAPI } from './API';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  payments : Payment[] = []

  constructor(private paymentAPI : PaymentAPI, private http : HttpClient) { }

  makePayment(payment : Payment){
    this.http.post<Payment>(this.paymentAPI.makePayment(), payment).subscribe(data => {
      this.payments.push(data);
    })
  }

  getPaymentByBookingID(bookingID : number){
    return this.http.get<Payment>(this.paymentAPI.getPaymentByBookingID(bookingID));
  }

  getAllPayments(){
    return this.http.get<Payment []>(this.paymentAPI.getAllPayments());
  }
}
