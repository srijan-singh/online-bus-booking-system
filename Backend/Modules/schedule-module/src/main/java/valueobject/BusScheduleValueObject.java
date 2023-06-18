package valueobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BusScheduleValueObject {

   
    private Long id;

    
    private String departureTime;


    private String arrivalTime;


    private Long routeID;
    
  
    private Double amount;
    
    public LocalDateTime stringToLocalDateTime(String string, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(string, formatter);
    }


	public BusScheduleValueObject(Long id, String departureTime, String arrivalTime, Long routeID, Double amount) {
		super();
		this.id = id;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.routeID = routeID;
		this.amount = amount;
	}


	public BusScheduleValueObject() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public Long getRouteID() {
		return routeID;
	}


	public void setRouteID(Long routeID) {
		this.routeID = routeID;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    

}
