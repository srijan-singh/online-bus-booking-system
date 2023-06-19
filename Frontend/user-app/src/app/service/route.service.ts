import { Injectable } from '@angular/core';
import { Route } from '../model/Route';
import { RouteFare } from '../model/RouteFare';
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

  getRouteByOriginAndDestination(origin: string, destination : string){
    console.log(this.routeAPI.getRouteByOriginAndDestination(origin, destination));
    return this.http.get<Route>(this.routeAPI.getRouteByOriginAndDestination(origin, destination))
  }

  getAllOrigins(){
    return this.http.get<string[]>(this.routeAPI.getAllOrigins());
  }

  getAllDestinations(){
    return this.http.get<string[]>(this.routeAPI.getAllDestinations());
  }

  getRouteFare(fareID : number = 1){
    return this.http.get<RouteFare>(this.routeAPI.getRouteFare(fareID));
  }

  getAllSlots(){
    return this.http.get<string[]>(this.routeAPI.getAllSlots());
  }
  
}
