# Online Bus Booking System

Group: Java Jedi

## Frontend

### User App

1. Sign Up

    ![Register](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_register.png)

2. Sign In

    ![Login](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_login.png)

3. Dashboard

    ![Dashboard](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/localhost_4200_dashboard.png)

## Entities and Relationships

![ER-Diagram](https://github.com/srijan-singh/online-bus-booking-system/blob/main/res/ER.jpeg)

## Entity Tables

### User
- id: integer, primary key
- name: varchar
- email: varchar
- password: varchar

### Booking
- id: integer, primary key
- user_id: integer, foreign key to User.id
- schedule_id: integer, foreign key to BusSchedule.id
- seat_number: integer
- status: varchar

### Review
- id: integer, primary key
- user_id: integer, foreign key to User.id
- rating: integer
- comment: varchar

### Cancellation
- id: integer, primary key
- booking_id: integer, foreign key to Booking.id
- user_id: integer, foreign key to User.id
- reason: varchar

### BusRoute
- id: integer, primary key
- origin: varchar
- destination: varchar

### BusSchedule
- id: integer, primary key
- bus_route_id: integer, foreign key to BusRoute.id
- departure_time: timestamp
- arrival_time: timestamp
- price: float

### Payment
- id: integer, primary key
- booking_id: integer, foreign key to Booking.id
- amount: float

