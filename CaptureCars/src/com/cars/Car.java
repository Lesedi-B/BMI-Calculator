package com.cars;

public class Car {
    private String make;
    private String model;
    private String platenumber;
    private String vin;
    private int year;
    private int mileage;

    // Getters & Setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getPlatenumber() { return platenumber; }
    public void setPlatenumber(String platenumber) { this.platenumber = platenumber; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    // Overridden toString for nice printing
    @Override
    public String toString() {
        return "Make: " + make +
                "\nModel: " + model +
                "\nPlate Number: " + platenumber +
                "\nVIN: " + vin +
                "\nYear: " + year +
                "\nMileage: " + mileage;
    }
}
