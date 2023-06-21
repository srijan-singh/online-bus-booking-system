import { Injectable } from '@angular/core';
import { Schedule } from '../model/Schedule';
import { ScheduleAPI } from './API';
import { HttpClient } from '@angular/common/http';
import { ScheduleValueObject } from '../model/ScheduleValueObject';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  schedules : Schedule[] = [] // Array to store schedules

  schedule : Schedule = new Schedule(); // Single schedule object

  scheduleAPI : ScheduleAPI = new ScheduleAPI(); // Instance of ScheduleAPI

  constructor(private http : HttpClient){}

  // Create a schedule by making a POST request to the ScheduleAPI
  createSchedule(schedule : ScheduleValueObject){
    return this.http.post<Schedule>(this.scheduleAPI.makeSchedule(), schedule);
  }

  // Get the number of booked seats by making a GET request to the ScheduleAPI
  getBookedSeats(departureTime : string, routeID : number){
    return this.http.get<Number>(this.scheduleAPI.getNNumberOfBookedScheduleByDepartureTimeAndRootID(departureTime, routeID));
  }

  // Get a schedule by its ID using a GET request to the ScheduleAPI
  getScheduleByID(scheduleID : number){
    return this.http.get<Schedule>(this.scheduleAPI.getScheduleByID(scheduleID));
  }

  // Get schedules for a specific route ID using a GET request to the ScheduleAPI
  getScheduleByRouteID(routeID : number){
    return this.http.get<Schedule []>(this.scheduleAPI.getScheduleByRouteID(routeID));
  }
}
