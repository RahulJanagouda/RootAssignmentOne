package com.rj.root.assignment.utils;

import com.rj.root.assignment.model.Driver;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SortUtilsTest {

    @Test
    public void Should_Pass_sortHashMapInReverseOrder() {
        //Arrange
        HashMap<String, Driver> inputDb = new HashMap<>();

        Driver one = new Driver("One");
        one.setTotalJourneyDistanceInMiles(1f);
        inputDb.put("One", one);

        Driver two = new Driver("Two");
        two.setTotalJourneyDistanceInMiles(2f);
        inputDb.put("Two", two);


        Driver three = new Driver("Three");
        three.setTotalJourneyDistanceInMiles(3f);
        inputDb.put("Three", three);

        //Act
        inputDb = SortUtils.sortDatabase(inputDb);

        //Assert
        assertEquals("Three", inputDb.keySet().toArray()[0]);
    }
}