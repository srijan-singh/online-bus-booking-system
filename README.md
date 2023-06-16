# Online Bus Booking System

Group: Java Jedi

<img src ="https://img.shields.io/github/repo-size/srijan-singh/online-bus-booking-system?color=succeess&label=Size"> 

<img src="https://img.shields.io/github/directory-file-count/srijan-singh/online-bus-booking-system/Backend/Modules?color=yellow&label=%20Backend%20Modules"> 

<img src="https://img.shields.io/github/directory-file-count/srijan-singh/online-bus-booking-system/Frontend?color=orange&label=%20Frontend%20Modules"> 


# Frontend

## User App

### Sign Up

![Register](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_register.png)

### Sign In

![Login](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_login.png)

### Dashboard

![Dashboard](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_dashboard.png)

# Backend (Microservice)

## API

This class is the base class for all the other classes in the code. It defines the protected properties `userAPI`, `bookingAPI`, `routeAPI`, `scheduleAPI`, and `paymentAPI`, which are the URLs for the different APIs.

### Methods

* `registerUser()`: Registers a new user.
* `loginUser()`: Logs in a user.
* `bookRide()`: Books a ride for a user.
* `cancelRide()`: Cancels a ride for a user.
* `reviewRide()`: Reviews a ride for a user.
* `getAllUsers()`: Gets all the users.

## UserAPI

This class extends the `API` class and provides methods for interacting with the user API.

### Methods

* `registerUser()`: Registers a new user.
* `loginUser()`: Logs in a user.
* `bookRide()`: Books a ride for a user.
* `cancelRide()`: Cancels a ride for a user.
* `reviewRide()`: Reviews a ride for a user.
* `getAllUsers()`: Gets all the users.

## BookingAPI

This class extends the `API` class and provides methods for interacting with the booking API.

### Methods

* `getBookingAPI()`: Gets the URL for the booking API.
* `getBookingbyUserID()`: Gets all the bookings for a user.
* `cancelBooking()`: Cancels a booking.
* `reviewBooking()`: Reviews a booking.

## RouteAPI

This class extends the `API` class and provides methods for interacting with the route API.

### Methods

* `addRoute()`: Adds a new route.
* `getRouteByID()`: Gets a route by its ID.
* `getRouteByOrigin()`: Gets all the routes that start at a given origin.
* `getAllOrigins()`: Gets all the origins.
* `getAllRoutes()`: Gets all the routes.

## ScheduleAPI

This class extends the `API` class and provides methods for interacting with the schedule API.

### Methods

* `makeSchedule()`: Creates a new schedule.
* `getScheduleByRouteID()`: Gets a schedule by its route ID.
* `getAllSchedules()`: Gets all the schedules.

## PaymentAPI

This class extends the `API` class and provides methods for interacting with the payment API.

### Methods

* `makePayment()`: Creates a new payment.
* `getPaymentByBookingID()`: Gets a payment by its booking ID.
* `getAllPayments()`: Gets all the payments.

# Database

## Entities and Relationships

![ER-Diagram](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/ER.jpeg)

## User
- id: integer, primary key
- name: varchar
- email: varchar
- password: varchar

## Booking
- id: integer, primary key
- user_id: integer, foreign key to User.id
- schedule_id: integer, foreign key to BusSchedule.id
- seat_number: integer
- status: varchar

## Review
- id: integer, primary key
- user_id: integer, foreign key to User.id
- rating: integer
- comment: varchar

## Cancellation
- id: integer, primary key
- booking_id: integer, foreign key to Booking.id
- user_id: integer, foreign key to User.id
- reason: varchar

## BusRoute
- id: integer, primary key
- origin: varchar
- destination: varchar

## BusSchedule
- id: integer, primary key
- bus_route_id: integer, foreign key to BusRoute.id
- departure_time: timestamp
- arrival_time: timestamp
- price: float

## Payment
- id: integer, primary key
- booking_id: integer, foreign key to Booking.id
- amount: float

