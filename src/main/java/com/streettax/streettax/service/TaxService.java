package com.streettax.streettax.service;
import com.streettax.streettax.dto.TaxCalculationRequest;
import com.streettax.streettax.dto.TaxCalculationResponse;
import com.streettax.streettax.model.VehicleType;
import com.streettax.streettax.model.RouteType;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    private static final double BASE_RATE_PER_KM = 5.0;

    public TaxCalculationResponse calculateTax(TaxCalculationRequest request) {

        double vehicleMultiplier = getVehicleMultiplier(request.getVehicleType());
        double routeMultiplier = getRouteMultiplier(request.getRouteType());
        double estimatedTax =
                request.getDistanceInKm() * BASE_RATE_PER_KM * vehicleMultiplier * routeMultiplier;

        TaxCalculationResponse response = new TaxCalculationResponse();
        response.setSourceCity(request.getSourceCity());
        response.setDestinationCity(request.getDestinationCity());
        response.setDistanceInKm(request.getDistanceInKm());
        response.setVehicleType(request.getVehicleType());
        response.setEstimatedTax(estimatedTax);

        return response;
    }

    private double getVehicleMultiplier(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return 1.0;
            case CAR:
                return 1.2;
            case TRUCK:
                return 1.5;
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }

    private double getRouteMultiplier(RouteType routeType){
        switch(routeType){
            case EXPRESSWAY : return 1.4;

            case STATE_HIGHWAY: return 1.0;

            case NATIONAL_HIGHWAY:return 1.2;

            default:
                throw new IllegalArgumentException("Unsupported route type");
        }
    }
}
