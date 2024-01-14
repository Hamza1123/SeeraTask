package org.example;

import Reading_Helper.XMLReader;
import Shared_Methods.DynamicDataGenerator;
import constatns.ApiConstant;
import error_handlers.StatusCodeValidator;
import org.testng.annotations.Test;

public class FlightSearchAPITest {

    @Test(description = "validate flight search return data")
    public void testFlightSearch() {
        String departureDate = DynamicDataGenerator.generateRandomDepartureDate();
        String returnDate = DynamicDataGenerator.generateRandomReturnDate(departureDate);
        FlightSearchService flightSearchService = new FlightSearchService();
        flightSearchService.initiateFlightSearch(XMLReader.getXMLData("originId"),
                XMLReader.getXMLData("destinationId"), departureDate,
                returnDate, XMLReader.getXMLData("cabin"), XMLReader.getXMLData("adult"));
        StatusCodeValidator.validateStatusCode(flightSearchService.serviceResponse, ApiConstant.SUCCESS);
    }
}