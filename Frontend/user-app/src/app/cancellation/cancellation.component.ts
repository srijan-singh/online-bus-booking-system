import { Component, OnInit } from '@angular/core';
import { BookingService } from '../service/booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancellation',
  templateUrl: './cancellation.component.html',
  styleUrls: ['./cancellation.component.css']
})

export class CancellationComponent implements OnInit {

  bookingID : number = 0;

  reason : string = "";

  constructor(private service : BookingService,
              private route : Router) { }

  ngOnInit(): void {
    this.bookingID = Number(localStorage.getItem('bookingID'));
  }

  async cancel(){
    await this.cancelBooking().then(
      ()=>{
        alert("Cancellation Request Accepted");
        this.backToDashboard();
      }
    )
  }

  async cancelBooking(){
    await this.service.cancelBooking(
      this.bookingID, 
      this.reason
      );
  }
  
  backToDashboard(){
    this.route.navigate(['/dashboard']);
  }
}
