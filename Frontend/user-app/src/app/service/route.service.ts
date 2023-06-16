import { Injectable } from '@angular/core';
import { Route } from '../model/Route';
import { RouteAPI } from './API';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  routes : Route[] = []

  route : Route = new Route();

  routeAPI : RouteAPI = new RouteAPI();

  constructor(private http : HttpClient) { }

  getRouteByID(routeID : number){
    return this.http.get<Route>(this.routeAPI.getRouteByID(routeID));
  }
  
}
