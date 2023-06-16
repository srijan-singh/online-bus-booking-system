import { Injectable } from '@angular/core';
import { Schedule } from '../model/Schedule';
import { ScheduleAPI } from './API';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  schedules : Schedule[] = []

  schedule : Schedule = new Schedule();

  scheduleAPI : ScheduleAPI = new ScheduleAPI();

  constructor(private http : HttpClient){}

  getScheduleByID(scheduleID : number){
    return this.http.get<Schedule>(this.scheduleAPI.getScheduleByID(scheduleID));
  }

  getScheduleByRouteID(routeID : number){
    return this.http.get<Schedule []>(this.scheduleAPI.getScheduleByRouteID(routeID));
  }
}
