package org.example;

import Reading_Helper.XMLReader;
import Shared_Methods.DynamicDataGenerator;
import constatns.ApiConstant;
import error_handlers.StatusCodeValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarFaresAPITest {

    Response apiResponse;

    @Test(description = "validate that API returns success and correct data")
    public void validatePostCalendarFaresApiStatusCode() {
        String departureDate = DynamicDataGenerator.generateRandomDepartureDate();
        String returnDate = DynamicDataGenerator.generateRandomReturnDate(departureDate);
        PostCalendarFaresService postCalendarFaresService = new PostCalendarFaresService();
        apiResponse = postCalendarFaresService.submitCalendarFares(departureDate, returnDate, XMLReader.getXMLData("adult"));
        StatusCodeValidator.validateStatusCode(PostCalendarFaresService.serviceResponse, ApiConstant.SUCCESS);
        apiResponse.getBody();
        JsonPath jsonPath = apiResponse.jsonPath();
        double price = jsonPath.getDouble(departureDate + ".price");
        Assert.assertNotEquals(price, null);
    }
}