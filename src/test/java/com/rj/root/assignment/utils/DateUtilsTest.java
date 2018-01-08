package com.rj.root.assignment.utils;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateUtilsTest {
    @Test
    public void Should_Pass_When_convertStringToDate() {

        //Arrange
        DateTime expectedDate = new DateTime()
                .withHourOfDay(7)
                .withMinuteOfHour(15)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        //Act
        DateTime actualDate = DateUtils.convertStringToDate("07:15");

        //Assert
        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void Should_Pass_When_differenceInHours() {

        //Arrange
        float expectedDifference = 0.5f;

        //Act
        float actualDifference = DateUtils.differenceInHours("07:15", "07:45");

        //Assert
        assertEquals(expectedDifference, actualDifference, 0);
    }

}