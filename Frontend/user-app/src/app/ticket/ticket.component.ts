import { Component, OnInit } from '@angular/core';
import { ScheduleService } from '../service/schedule.service';
import { Router } from '@angular/router';
import { Schedule } from '../model/Schedule';
import { firstValueFrom } from 'rxjs';
import { Route } from '../model/Route';
import { RouteService } from '../service/route.service';
import { Email } from '../model/Email';
import { EmailService } from '../service/email.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit{

  email : Email = new Email();

  scheduleID : number = 0

  bookingID : number = 0;

  seatNumber : number = 0

  schedule : Schedule = new Schedule();

  bus_route : Route = new Route();

  departure : Date = new Date();

  arrival : Date = new Date();

  userName : string = "";
  
  constructor(private scheduleService : ScheduleService, 
              private routeService : RouteService,
              private emailService : EmailService,
              private route : Router){}

  ngOnInit(): void {

    this.userName = String(localStorage.getItem('userName'));

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
  
  // Generate Ticket for Email

  getSubject() : string{
    const userName = String(localStorage.getItem('userName'));

    return `${userName}, your journey begins: Your Yatra bus ticket is here!`;
  }

  getTicketData(): string {

      const userName = String(localStorage.getItem('userName'));

      const pnr = `${this.bookingID}`;
      const seatNumberStr= ` ${this.seatNumber}`;

      // Format the departure time using `toLocaleDateString()` and `toLocaleTimeString()`
      // to get a more readable date and time format, respectively.
      // You can adjust the formatting options as needed.

      const departureInfo=`Departure Time : ${this.departure} from ${this.bus_route.origin}`

      const arrivalInfo=`Arrival Time : ${this.arrival} at ${this.bus_route.destination}`
      
      const durationHoursMinutesSeconds=this.getDurationString();

      // Define the ticket info as a string template with variables:
      return `Dear, ${userName}
      
              \nGet ready to embark on a seamless journey with Yatra! Your bus ticket details.

              \nTicket Details

              \nPNR: ${pnr}
              \nSeat Number: ${seatNumberStr}
              \nDeparture
              \n${departureInfo}
              \nArrival
              \n${arrivalInfo}
              \nDistance in km: ${this.bus_route.distance}
              \nExpected Duration in hours: ${this.bus_route.duration}
              \nAmount in rupees: Rs. ${this.schedule.amount}
              \nDuration (hh:mm:ss): ${durationHoursMinutesSeconds}
              \n\nHappy Journey!`;
  }

  getDurationString(): string {
      const diffMs = new Date(this.schedule.arrivalTime).getTime() - new Date(this.schedule.departureTime).getTime();
      const hours = Math.floor(diffMs / 3600000);
      const minutes = Math.floor((diffMs % 3600000) / 60000);
        // Use `padStart()` to add leading zeros for single-digit numbers.
      return `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:00`;
  }

  // Send Email

  async emailTicket(){
    await this.sendEmail().then(
      () =>{
      alert("Ticket has been sent to you email!")
      }
    );
  }

  async sendEmail(){
    this.email.to = String(localStorage.getItem("userEmail"));
    this.email.subject = this.getSubject();
    this.email.text = this.getTicketData();

    return await this.emailService.sendEmail(this.email).subscribe(
      data => {
        
        this.email = data;
        console.log(data);
      }
    )

  }

  // Route

  backToDashboard(){
    
    localStorage.removeItem('scheduleID');

    localStorage.removeItem('seatNumber');

    this.route.navigate(['/dashboard']);
  }

}
