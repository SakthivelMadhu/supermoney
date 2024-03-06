package main.java.com.flipkar.service;

import main.java.com.flipkar.model.Branch;
import main.java.com.flipkar.model.Vehicle;
import main.java.com.flipkar.strategy.DefaultSelectionStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RentalService {

    private List<Branch> branches;
    private DefaultSelectionStrategy selectionStrategy;

    // Constructor
    public RentalService(DefaultSelectionStrategy defaultSelectionStrategy) {
        this.selectionStrategy = defaultSelectionStrategy;
    }

    // Getter for branches
    public List<Branch> getBranches() {
        return branches;
    }

    // Method to onboard a new branch with available vehicles
    public void addBranch(String name, List<String> vehicleDetails) {
        Branch newBranch = new Branch(name, null);
    
        for (String vehicleDetail : vehicleDetails) {
            String[] parts = vehicleDetail.split(" ");
    
            // Extracting quantity and type
            int quantity = Integer.parseInt(parts[0]);
            String type = parts[1].toLowerCase();
    
            // Extracting price from the details
            double pricePerHour = extractPrice(vehicleDetail);
    
            Vehicle vehicle = new Vehicle(type, quantity, pricePerHour);
            newBranch.addVehicle(vehicle);
        }
    }
    
    // Helper method to extract price from the vehicle details
    private double extractPrice(String vehicleDetail) {
        String[] parts = vehicleDetail.split(" ");

        // Loop through the parts in reverse order to find the 1st valid numeric value
        for (int i = parts.length - 1; i >= 0; i--) {
            String potentialPrice = parts[i].replaceAll("[^\\d.]", "");
            if (!potentialPrice.isEmpty()) {
                try {
                    return Double.parseDouble(potentialPrice);
                } catch (NumberFormatException e) {
                    // Handle invalid price format gracefully
                    System.err.println("Invalid price format for: " + vehicleDetail);
                    return 0.0; // Default to 0.0 if price parsing fails
                }
            }
        }

        // Return a default value or handle the case where no valid price is found
        throw new UnsupportedOperationException("Invalid price format for: " + vehicleDetail);
    }



    // Method to add new vehicle(s) of an existing type to a particular branch
    public void addVehicle(String branchName, String vehicleDetails) {
        if (branches == null) {
            return;
        }

        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                String[] parts = vehicleDetails.split(" ");
                int quantity = Integer.parseInt(parts[0]);
                String type = parts[1].toLowerCase();

                Vehicle existingVehicle = branch.getVehicleByType(type);
                if (existingVehicle != null) {
                    existingVehicle.setQuantity(existingVehicle.getQuantity() + quantity);
                } else {
                    Vehicle newVehicle = new Vehicle(type, quantity, 0); // Price not specified in the input
                    branch.addVehicle(newVehicle);
                }
                return;
            }
        }

    }

    // Method to rent a vehicle for a time slot and a vehicle type
    public void rentVehicle(String vehicleType, String startTimeStr, String endTimeStr) {
        if (branches == null) {
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM hh:mm a");
            Date startTime = dateFormat.parse(startTimeStr);
            Date endTime = dateFormat.parse(endTimeStr);

            for (Branch branch : branches) {
                if (branch.hasAvailableVehicle(vehicleType, startTime, endTime)) {
                    Vehicle selectedVehicle = branch.getAvailableVehicle(vehicleType, startTime, endTime);
                    branch.bookVehicle(selectedVehicle, startTime, endTime);
                    return;
                }
            }

            // Fallback to another branch if the vehicle is not available
            Branch selectedBranch = selectionStrategy.selectBranch(branches, new Vehicle(vehicleType, 0, 0));
            if (selectedBranch != null) {
                Vehicle selectedVehicle = selectedBranch.getAvailableVehicle(vehicleType, startTime, endTime);
                selectedBranch.bookVehicle(selectedVehicle, startTime, endTime);
            } else {
            }
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
    }

    public void printSystemViewForTimeSlot(String startTimeStr, String endTimeStr) {
        if (branches == null) {
            return;
        }
    
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM hh:mm a");
            Date startTime = dateFormat.parse(startTimeStr);
            Date endTime = dateFormat.parse(endTimeStr);
    
            for (Branch branch : branches) {
                System.out.println("'" + branch.getName() + "':");
                branch.printSystemView(startTime, endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
    }
    
}
