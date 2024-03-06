package main.java.com.flipkar.model;

import java.util.Date;

public class Booking {
    private Vehicle vehicle;
    private Date startTime;
    private Date endTime;
    
    // Constructors
    public Booking(Vehicle vehicle, Date startTime, Date endTime) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter and setter methods

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
