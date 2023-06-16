export class Schedule{
    
    public id : number = 0;
    public departureTime : Date = new Date();
    public arrivalTime : Date = new Date();
    public availableSeats : number = 0;
    public routeID : number = 0;
    public bookingID : number = 0;
    public amount : number = 0.0;

    public setArrivalTime(arrivalTime : Date) {
        this.arrivalTime = arrivalTime;
    }

    public setDepartureTime(departureTime : Date) {
        this.departureTime = departureTime;
    }
}