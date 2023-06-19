import { Component, OnInit } from '@angular/core';
import { ScheduleService } from '../service/schedule.service';
import { Router } from '@angular/router';
import { Schedule } from '../model/Schedule';
import { firstValueFrom } from 'rxjs';
import { Route } from '../model/Route';
import { RouteService } from '../service/route.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit{

  scheduleID : number = 0

  bookingID : number = 0;

  seatNumber : number = 0

  schedule : Schedule = new Schedule();

  bus_route : Route = new Route();

  departure : Date = new Date();

  arrival : Date = new Date();
  
  constructor(private scheduleService : ScheduleService, 
              private routeService : RouteService,
              private route : Router){}

  ngOnInit(): void {

    this.scheduleID = Number(localStorage.getItem('scheduleID'));

    this.bookingID = Number(localStorage.getItem('bookingID'));

    this.seatNumber = Number(localStorage.getItem('seatNumber'));

    this.showTicket();

  }

  async showTicket(){
    try {
      const data = await firstValueFrom(this.scheduleService.getScheduleByID(this.scheduleID));
      
      this.schedule = data;

      setTimeout(async () => {

        await this.getRoute(this.schedule.routeID);

        this.departure = new Date(this.schedule.departureTime);
        this.arrival = new Date(this.schedule.arrivalTime);

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

  // Route

  backToDashboard(){
    
    localStorage.removeItem('scheduleID');

    localStorage.removeItem('seatNumber');

    this.route.navigate(['/dashboard']);
  }

}
