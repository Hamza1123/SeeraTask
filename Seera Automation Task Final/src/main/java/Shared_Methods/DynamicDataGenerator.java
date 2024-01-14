package Shared_Methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class DynamicDataGenerator {

    public static String generateRandomDepartureDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate departureDate = generateRandomDate(currentDate, currentDate.plusMonths(6)); // Dates within the next 6 months
        return departureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String generateRandomReturnDate(String departureDate) {
        LocalDate departureLocalDate = LocalDate.parse(departureDate);
        LocalDate returnDate = departureLocalDate.plusDays(7); // Return date, 7 days after the departure date
        return returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        return LocalDate.ofEpochDay(randomEpochDay);
    }
}