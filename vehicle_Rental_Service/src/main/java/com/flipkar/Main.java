package main.java.com.flipkar;

import java.util.Arrays;

import main.java.com.flipkar.service.RentalService;
import main.java.com.flipkar.strategy.DefaultSelectionStrategy;

public class Main {

	public static void main(String[] args) {
        RentalService rentalService = new RentalService(new DefaultSelectionStrategy());

        // Onboard branches
        rentalService.addBranch("Koramangala", Arrays.asList("1 SUV for Rs. 12 per hour", "3 sedan for Rs. 10 per hour", "3 bikes for Rs.20 per hour"));
        rentalService.addBranch("Jayanagar", Arrays.asList("3 sedan for Rs.11 per hour", "3 bikes for Rs.30 per hour", "4 hatchback for Rs.8 per hour"));
        rentalService.addBranch("Malleshwaram", Arrays.asList("1 SUV for Rs.11 per hour", "10 bikes for Rs.3 per hour", "3 sedan for Rs.10 per hour"));

        // Add vehicle to a branch
        rentalService.addVehicle("Koramangala", "1 sedan");

        // Rent vehicles
        rentalService.rentVehicle("suv", "20-Feb 10:00 AM", "20-Feb 12:00 PM"); // should book from Malleshwaram
        rentalService.rentVehicle("suv", "20-Feb 10:00 AM", "20-Feb 12:00 PM"); // should book from Koramangala
        rentalService.rentVehicle("suv", "20-Feb 10:00 AM", "20-Feb 12:00 PM"); // Should fail saying no vehicle

        // Print system view for a time slot
        rentalService.printSystemViewForTimeSlot("20-Feb 11:00 PM", "20-Feb 12:00 PM");
    }

}
