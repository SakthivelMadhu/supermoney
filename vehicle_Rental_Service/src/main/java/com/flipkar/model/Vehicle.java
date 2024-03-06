package main.java.com.flipkar.model;

public class Vehicle {

    private String type;
    private int quantity;
    private double pricePerHour;

    // Constructors
    public Vehicle(String type, int quantity, double pricePerHour) {
        this.type = type;
        this.quantity = quantity;
        this.pricePerHour = pricePerHour;
    }

    // Getter and setter methods
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
