# supermoney

# Vehicle Rental Service

## Overview

Flipkart's Vehicle Rental Service, named Flipkar, is a platform that enables users to rent different types of vehicles such as cars and bikes. This service operates through multiple branches across the city, each with a limited number of vehicles available for rent.

## Features

1. **Branch Management:**
   - Onboard new branches with available vehicles.
   - Add new vehicles of existing types to a particular branch.

2. **Vehicle Booking:**
   - Rent vehicles for specified time slots.
   - Default selection strategy for choosing available vehicles.

3. **System View:**
   - View the status of booked and available vehicles across all branches.

## Requirements

- Java Development Kit (JDK)
- JUnit for testing

## Project Structure

```plaintext
supermoney
│   README.md
│
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───flipkar
│   │               ├───model
│   │               │   Branch.java
│   │               │   Vehicle.java
│   │               │   Booking.java
│   │               ├───service
│   │               │   RentalService.java
│   │               ├───strategy
│   │               │   VehicleSelectionStrategy.java
│   │               │   DefaultSelectionStrategy.java
│   │               └───util
│   │                   DateUtil.java
|   |               Main.java
│   └───test
│       └───java
│           └───com
│               └───flipkar
│                   └───test
│                       RentalServiceTest.java
