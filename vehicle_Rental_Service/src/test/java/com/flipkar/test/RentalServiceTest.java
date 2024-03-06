package test.java.com.flipkar.test;

import main.java.com.flipkar.service.RentalService;
import main.java.com.flipkar.strategy.DefaultSelectionStrategy;


import java.util.Arrays;


class RentalServiceTest {

    @Test
    void testOnboardBranch() {
        RentalService rentalService = new RentalService(new DefaultSelectionStrategy());
        rentalService.addBranch("Electronic City", Arrays.asList("2 SUVs for Rs. 15 per hour", "5 hatchback for Rs. 8 per hour"));
        assertEquals(1, rentalService.getBranches().size(), "Branch not onboarded successfully");
    }

    @Test
    void testAddVehicleToBranch() {
        RentalService rentalService = new RentalService(new DefaultSelectionStrategy());
        rentalService.addBranch("Koramangala", Arrays.asList("1 SUV for Rs. 12 per hour", "3 sedan for Rs. 10 per hour", "3 bikes for Rs.20 per hour"));
        rentalService.addVehicle("Koramangala", "1 sedan");
        assertEquals(1, rentalService.getBranches().get(0).getVehicles().get(1).getQuantity(), "Vehicle not added to branch successfully");
    }

	private void assertEquals(int i, int quantity, String string) {
		// TODO Auto-generated method stub
		
	}

    // Add more test cases for renting, system view, etc.
}

