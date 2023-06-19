import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})

export class PaymentGatewayComponent implements OnInit {

  message : string = "";

  reverseTime = 10;
  reverseTimerInterval :any ;

  constructor(private route : Router) { }

  ngOnInit() {

    this.message = String(localStorage.getItem("message"));

    this.reverseTimerInterval = setInterval(() => {
      this.reverseTime--;

      if(this.reverseTime == 0){
        this.ngOnDestroy();
        alert(this.message);
        this.route.navigate(['/dashboard']);
      }

    }, 1000);

  }

  ngOnDestroy() {
    clearInterval(this.reverseTimerInterval);
    localStorage.removeItem('message');
  }



}
