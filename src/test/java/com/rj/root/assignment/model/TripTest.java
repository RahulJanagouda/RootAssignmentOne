package com.rj.root.assignment.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripTest {
    private Trip trip;

    @Before
    public void setUp() throws Exception {
        trip = new Trip("07:15", "07:45", "17.3");
    }

    @Test
    public void Should_Pass_When_setters_And_getters_StartTime() throws Exception {
        //Arrange
        DateTime expectedStartTime = new DateTime()
                .withHourOfDay(7)
                .withMinuteOfHour(15)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        //Act
        trip.setStartTime(expectedStartTime);
        DateTime actualStartTime = trip.getStartTime();

        //Assert
        assertEquals(expectedStartTime, actualStartTime);
    }

    @Test
    public void Should_Pass_When_setters_And_getters_EndTime() throws Exception {
        //Arrange
        DateTime expectedEndTime = new DateTime()
                .withHourOfDay(7)
                .withMinuteOfHour(15)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        //Act
        trip.setEndTime(expectedEndTime);
        DateTime actualEndTime = trip.getEndTime();

        //Assert
        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void Should_Pass_When_setters_And_getters_DistanceInMiles() throws Exception {
        //Arrange
        Float expectedDistanceInMiles = 2.5f;

        //Act
        trip.setDistanceInMiles(expectedDistanceInMiles);
        Float actualDistanceInMiles = trip.getDistanceInMiles();

        //Assert
        assertEquals(expectedDistanceInMiles, actualDistanceInMiles);
    }

    @Test
    public void Should_Pass_When_setters_And_getters_RoundedSpeed() throws Exception {
        //Arrange
        int expectedDistanceInMiles = 35;

        //Act
        Trip speedTrip = new Trip("07:15", "07:45", "17.3");
        int actualDistanceInMiles = speedTrip.getRoundedSpeed();

        //Assert
        assertEquals(expectedDistanceInMiles, actualDistanceInMiles);
    }


}