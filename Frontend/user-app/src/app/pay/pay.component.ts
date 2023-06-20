import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { Pay } from '../model/Pay';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html', 
  styleUrls: ['./pay.component.css'],
  encapsulation: ViewEncapsulation.ShadowDom
})
export class PayComponent implements OnInit{
  
pay : Pay =new Pay();
constructor(private route : Router){
  
}
ngOnInit(): void {
    
}
save(){
  this.route.navigate(['/payment-gateway'])
}
}
