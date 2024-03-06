package main.java.com.flipkar.strategy;

import java.util.List;

import main.java.com.flipkar.model.Branch;
import main.java.com.flipkar.model.Vehicle;

public  interface VehicleSelectionStrategy {
	
	 Branch selectBranch(List<Branch> branches , Vehicle vehicle);

}
