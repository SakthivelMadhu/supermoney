package main.java.com.flipkar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Branch {

    private String name;
    private List<Vehicle> vehicles;

    // Constructors
    public Branch(String name, List<Vehicle> vehicles) {
		this.name = name;
		this.vehicles = (vehicles == null) ? new ArrayList<>() : vehicles;
	}

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    // Other methods
    public int getAvailableQuantity(String type) {
        //  return 0 for now
        return 0;
    }

    public int getVehiclePrice(String type) {
        //  return 0 for now
        return 0;
    }

    public Vehicle getVehicleByType(String type) {
        // return null for now
        return null;
    }

    public void addVehicle(Vehicle newVehicle) {
        //  add the new vehicle to the list
        vehicles.add(newVehicle);
    }

    public boolean hasAvailableVehicle(String vehicleType, Date startTime, Date endTime) {
        //  return false for now
        return false;
    }

    public Vehicle getAvailableVehicle(String vehicleType, Date startTime, Date endTime) {
        //  return null for now
        return null;
    }

    public void bookVehicle(Vehicle selectedVehicle, Date startTime, Date endTime) {
        //  do nothing for now
    }

    public void printSystemView(Date startTime, Date endTime) {
        // print a message for now
        System.out.println("System view not implemented yet");
    }
}
