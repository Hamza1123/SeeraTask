package org.example;

import apihelpers.ApiUtilities;
import constatns.ApiConstant;
import io.restassured.response.Response;
import rest_assured.PostApiHelper;

import java.util.Objects;

public class PostCalendarFaresService {

    public static Response serviceResponse;

    public Response submitCalendarFares(String departureFrom, String departureTo, String adultCount) {
        String requestBody = "{\"leg\":[{\"originId\":\"RUH\",\"destinationId\":\"JED\",\"departureFrom\":\"" + departureFrom + "\"" +
                ",\"departureTo\":\"" + departureTo + "\"}],\"cabin\":\"Economy\",\"pax\":{\"adult\":" + adultCount + ",\"child\":0,\"infant\":0},\"stops\":[],\"airline\":[],\"timeSlots\":{},\"airports\":{}}";
        serviceResponse = Objects.requireNonNull(PostApiHelper.post(ApiConstant.PostCalenderFaresApi, ApiUtilities.headers(), requestBody));
        serviceResponse.getBody().prettyPrint();
        return serviceResponse;
    }
}