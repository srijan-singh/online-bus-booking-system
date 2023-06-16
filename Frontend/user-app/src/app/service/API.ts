export class API{
 
    protected userAPI = "http://localhost:9001/" + "user/";

    protected bookingAPI =  "http://localhost:9002/" + "booking/";

    protected routeAPI =  "http://localhost:9003/" + "route/";

    protected scheduleAPI =  "http://localhost:9004/" + "schedule/";

    protected paymentAPI =  "http://localhost:9005/" + "payment/";

}

export class UserAPI extends API{
    constructor(){
        super();
    }
  
    public registerUser(){
        return this.userAPI+"registeration";
    }
  
    public loginUser(){
        return this.userAPI+"login";
    }
  
    public bookRide(userID : number){
        return this.userAPI+"bookRide/"+userID;
    }
  
    public cancelRide(bookingID : number){
        return this.userAPI+"cancelRide/"+bookingID;
    }
  
    public reviewRide(bookingID : number){
        return this.userAPI+"reviewRide/"+bookingID;
    }
  
    public getAllUsers(){
        return this.userAPI+"listAll"
    }
  }

export class BookingAPI extends API {

    constructor() {
      super();
    }

    public getBookingAPI(){
        return this.bookingAPI;
    }

    public getBookingbyUserID(userID : string){
        return this.bookingAPI+"all/"+userID;
    }

    public cancelBooking(bookingID : number){
        return this.bookingAPI+"cancel/"+bookingID
    }

    public reviewBooking(bookingID : number){
        return this.bookingAPI+"review/"+bookingID
    }
    
  }

export class RouteAPI extends API{

    constructor(){
        super();
    }
    
    public addRoute(){
        return this.routeAPI+"add";
    }

    public getRouteByID(routeID : number){
        return this.routeAPI+"get/"+routeID;
    }

    public getRouteByOrigin(origin : string){
        return this.routeAPI+"origin/"+origin;
    }

    public getAllOrigins(){
        return this.routeAPI+"origin/all"
    }

    public getAllRoutes(){
        return this.routeAPI+"all";
    }
}
  
export class ScheduleAPI extends API{
    
    constructor(){
        super();
    }    
    
    public makeSchedule(){
        return this.scheduleAPI;
    }

    public getScheduleByRouteID(routeID : number){
        return this.scheduleAPI+"findByRoute/"+routeID;
    }

    public getAllSchedules(){
        return this.scheduleAPI+"all";
    }
}

export class PaymentAPI extends API{

    constructor(){
        super();
    }

    public makePayment(){
        return this.paymentAPI;
    }

    public getPaymentByBookingID(bookingID : number){
        return this.paymentAPI+bookingID;
    }

    public getAllPayments(){
        return this.paymentAPI+"all";
    }
}