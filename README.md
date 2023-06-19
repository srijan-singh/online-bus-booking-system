# Online Bus Booking System

Group: Java Jedi

<img src ="https://img.shields.io/github/repo-size/srijan-singh/online-bus-booking-system?color=succeess&label=Size"> <img src="https://img.shields.io/github/directory-file-count/srijan-singh/online-bus-booking-system/Backend/Modules?color=yellow&label=%20Backend%20Modules"> <img src="https://img.shields.io/github/directory-file-count/srijan-singh/online-bus-booking-system/Frontend?color=orange&label=%20Frontend%20Modules"> 


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
* `getRouteByOriginAndDestinnation()`: Gets all the routes with given origin and destination.
* `getAllOrigins()`: Gets all the origins.
* `getAllDestinations()`: Gets all the origins.
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
- distance: double
- duration : time
- available_seats : int

## BusSchedule
- id: integer, primary key
- bus_route_id: integer, foreign key to BusRoute.id
- departure_time: timestamp
- arrival_time: timestamp
- amount: float

## Payment
- id: integer, primary key
- booking_id: integer, foreign key to Booking.id
- amount: float

# Querry

## Old Values

    INSERT INTO bus_route (route_id, destination, origin, distance, duration, available_seats)
    VALUES (107, 'Delhi', 'Agra', 220, '04:00:00', 30),
           (109, 'Varanasi', 'Agra', 612, '10:00:00', 30),
           (110, 'Varanasi', 'Delhi', 821, '13:00:00', 30),
           (112, 'Agra', 'Delhi', 220, '04:00:00', 30),
           (113, 'Delhi', 'Varanasi', 821, '13:00:00', 30),
           (115, 'Agra', 'Varanasi', 612, '10:00:00', 30);

## Schedule Population

        INSERT INTO bus_schedule (arrival_time, departure_time, route_id, amount)
        VALUES
        (1, '2023-06-14 15:00:00', '2023-06-14 12:00:00', 107, 610),
        (2, '2023-06-19 23:00:00', '2023-06-19 20:00:00', 113, 910.5),
        (3, '2023-06-20 11:00:00', '2023-06-20 09:00:00', 109, 806),
        (4, '2023-06-21 15:00:00', '2023-06-21 13:00:00', 110, 910.5);
