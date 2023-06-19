import { Component, OnInit } from '@angular/core';
import { BookingService } from '../service/booking.service';
import { Router } from '@angular/router';
import { set } from 'date-fns';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  bookingID : number = 0;

  raiting : number = 0;

  comment : string= "";

  constructor(private service : BookingService,
              private route : Router) { }

  ngOnInit(): void {
    this.bookingID = Number(localStorage.getItem('bookingID'));
  }

  async review(){
    await this.makeReview().then(
      ()=>{

        alert("Review Submitted Successfully");
        this.backToDashboard();

      }
    )
  }

  async makeReview() {
    
    if (this.comment != '') {
      await this.service.reviewBooking(
        this.bookingID,
        String(this.raiting),
        this.comment
      );
    }
  }

  backToDashboard(){
    this.route.navigate(['/dashboard']);
  }

}
