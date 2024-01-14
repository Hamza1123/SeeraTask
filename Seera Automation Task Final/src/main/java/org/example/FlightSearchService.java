package org.example;

import apihelpers.ApiUtilities;
import constatns.ApiConstant;
import io.restassured.response.Response;
import rest_assured.GetApiHelper;

import java.util.Objects;

public class FlightSearchService {

    public static Response serviceResponse;

    public Response initiateFlightSearch(String originId, String destinationId, String departure,
                                         String arrival, String cabinClass, String passengerCount) {

        ApiConstant.setFlightSearch(originId, destinationId, departure, arrival, cabinClass, passengerCount);
        serviceResponse = Objects.requireNonNull(GetApiHelper.getResponseByHeaders(ApiConstant.Flight_Search, ApiUtilities.headers()));
        serviceResponse.getBody().prettyPrint();
        return serviceResponse;
    }
}