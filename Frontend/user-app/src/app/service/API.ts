export class API{
    
    private baseURL = "http://localhost:9000/";
 
    public getBaseURL(){
        return this.baseURL;
    }

}

export class UserAPI extends API{
    constructor(){
        super();
    }
  
    private userAPI = "http://localhost:9001/" + "user/";
  
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

    private bookingAPI =  "http://localhost:9002/" + "booking/";

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

    private routeAPI = this.getBaseURL() + "route/";
    
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

    private scheduleAPI = this.getBaseURL() + "schedule/";
    
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

    private paymentAPI = this.getBaseURL() + "payment/";

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