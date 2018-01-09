package com.rj.root.assignment.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DriverTest {
    private Driver driver;

    @Before
    public void setUp() throws Exception {
        driver = new Driver("Dan");
    }

    @Test
    public void Should_Pass_When_set_And_get_DriverName() throws Exception {
        //Arrange
        String expectedDriverName = "Alex";
        driver.setDriverName(expectedDriverName);

        //Act
        String actualDriverName = driver.getDriverName();

        //Assert
        assertEquals(expectedDriverName, actualDriverName);
    }


    @Test
    public void Should_Pass_When_add_And_get_DriverTrips() throws Exception {
        //Arrange
        int expectedSize = 1;

        //Act
        driver.addTrip("07:15", "07:45", "17.3");

        //Assert
        int actualSize = driver.getDriverTrips().size();
        assertEquals(expectedSize, actualSize);
    }


    @Test
    public void Should_Pass_When_get_And_set_TotalJourneyTimeInHour() throws Exception {
        //Arrange
        Float expectedTotalJourneyTimeInHour = 1f;

        //Act
        driver.setTotalJourneyTimeInHour(1f);

        //Assert
        Float actualTotalJourneyTimeInHour = driver.getTotalJourneyTimeInHour();
        assertEquals(expectedTotalJourneyTimeInHour, actualTotalJourneyTimeInHour);
    }

    @Test
    public void Should_Pass_When_get_And_set_TotalJourneyDistanceInMiles() throws Exception {
        //Arrange
        Float expectedTotalJourneyDistanceInMiles = 1f;

        //Act
        driver.setTotalJourneyDistanceInMiles(1f);

        //Assert
        Float actualTotalJourneyDistanceInMiles = driver.getTotalJourneyDistanceInMiles();
        assertEquals(expectedTotalJourneyDistanceInMiles, actualTotalJourneyDistanceInMiles);
    }


    @Test
    public void Should_Pass_When_toString() throws Exception {

        //Arrange
        String expectedString = "Dan: 17 miles @ 35 mph";

        //Act
        driver.addTrip("07:15", "07:45", "17.3");

        //Assert
        String actualString = driver.toString();
        assertEquals(expectedString, actualString);
    }


    @Test
    public void Should_Pass_When_AddTrip_Computes_TotalJourneyTimeInHour() throws Exception {
        //Arrange
        Float expectedTotalJourneyTimeInHour = 0.8333334f;

        //Act
        driver.addTrip("07:15", "07:45", "17.3");
        driver.addTrip("06:12", "06:32", "21.8");

        //Assert
        Float actualTotalJourneyTimeInHour = driver.getTotalJourneyTimeInHour();
        assertEquals(expectedTotalJourneyTimeInHour, actualTotalJourneyTimeInHour);
    }


    @Test
    public void Should_Pass_When_AddTrip_Computes_TotalJourneyDistanceInMiles() throws Exception {
        //Arrange
        Float expectedTotalJourneyDistanceInMiles = 39.1f;

        //Act
        driver.addTrip("07:15", "07:45", "17.3");
        driver.addTrip("06:12", "06:32", "21.8");

        //Assert
        Float actualTotalJourneyDistanceInMiles = driver.getTotalJourneyDistanceInMiles();
        assertEquals(expectedTotalJourneyDistanceInMiles, actualTotalJourneyDistanceInMiles);
    }

}