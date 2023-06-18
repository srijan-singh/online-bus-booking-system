import { Injectable } from '@angular/core';
import { Schedule } from '../model/Schedule';
import { ScheduleAPI } from './API';
import { HttpClient } from '@angular/common/http';
import { ScheduleValueObject } from '../model/ScheduleValueObject';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  schedules : Schedule[] = []

  schedule : Schedule = new Schedule();

  scheduleAPI : ScheduleAPI = new ScheduleAPI();

  constructor(private http : HttpClient){}

 

  createSchedule(schedule : ScheduleValueObject){
    return this.http.post<Schedule>(this.scheduleAPI.makeSchedule(), schedule);
  }

  getBookedSeats(departureTime : string, routeID : number){
    return this.http.get<Number>(this.scheduleAPI.getNNumberOfBookedScheduleByDepartureTimeAndRootID(departureTime, routeID));
  }

  getScheduleByID(scheduleID : number){
    return this.http.get<Schedule>(this.scheduleAPI.getScheduleByID(scheduleID));
  }

  getScheduleByRouteID(routeID : number){
    return this.http.get<Schedule []>(this.scheduleAPI.getScheduleByRouteID(routeID));
  }
}
