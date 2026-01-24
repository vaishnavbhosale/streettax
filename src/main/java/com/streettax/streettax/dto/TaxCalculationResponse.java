package com.streettax.streettax.dto;

import com.streettax.streettax.model.VehicleType;

public class TaxCalculationResponse {

    private String sourceCity;
    private String destinationCity;
    private int distanceInKm;
    private VehicleType vehicleType;
    private double estimatedTax;

    public TaxCalculationResponse() {
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getEstimatedTax() {
        return estimatedTax;
    }

    public void setEstimatedTax(double estimatedTax) {
        this.estimatedTax = estimatedTax;
    }
}
