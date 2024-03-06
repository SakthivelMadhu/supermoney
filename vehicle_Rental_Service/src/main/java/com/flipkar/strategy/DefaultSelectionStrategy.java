package main.java.com.flipkar.strategy;

import main.java.com.flipkar.model.Branch;
import main.java.com.flipkar.model.Vehicle;

import java.util.List;

public class DefaultSelectionStrategy implements VehicleSelectionStrategy {

    @Override
    public Branch selectBranch(List<Branch> branches, Vehicle vehicle) {
        if (branches == null || branches.isEmpty()) {
            return null; // No available branches
        }

        Branch selectedBranch = branches.get(0); // Default to the first branch

        for (Branch branch : branches) {
            // Compare availability and pricing to select the branch
            if (branch.getAvailableQuantity(vehicle.getType()) > selectedBranch.getAvailableQuantity(vehicle.getType()) ||
                (branch.getAvailableQuantity(vehicle.getType()) == selectedBranch.getAvailableQuantity(vehicle.getType()) &&
                 branch.getVehiclePrice(vehicle.getType()) < selectedBranch.getVehiclePrice(vehicle.getType()))) {
                selectedBranch = branch;
            }
        }

        return selectedBranch;
    }
}
