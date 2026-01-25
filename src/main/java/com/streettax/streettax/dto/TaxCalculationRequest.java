package com.streettax.streettax.dto;
import com.streettax.streettax.model.RouteType;
import com.streettax.streettax.model.VehicleType;

public class TaxCalculationRequest {

    private String sourceCity;
    private String destinationCity;
    private int distanceInKm;
    private VehicleType vehicleType;
    private RouteType routeType;

    public TaxCalculationRequest() {
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

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }
    public RouteType getRouteType(){
        return routeType;
    }
}
