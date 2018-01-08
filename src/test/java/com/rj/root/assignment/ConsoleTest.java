package com.rj.root.assignment;

import com.rj.root.assignment.exceptions.DriverNotFoundException;
import com.rj.root.assignment.exceptions.UnknownCommandException;
import com.rj.root.assignment.model.Driver;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {
    @Test
    public void YouShallAlwaysPass() throws Exception {
        //Arrange
        //Act
        //Assert
        assertTrue(true);
    }

    @Test
    public void Should_Pass_Initially_DataBaseSizeIsEmpty() {
        //Arrange
        Console console = new Console();

        //Act
        boolean isDatabaseEmpty = console.getDataBase().isEmpty();

        //Assert
        assertTrue(isDatabaseEmpty);
    }


    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(1, database.size());
        assertEquals("Dan", database.get("Dan").getDriverName());
    }

    @Test(expected = UnknownCommandException.class)
    public void Should_Throw_When_parseCommand_RandomText() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Hello Dan");

        //Assert
    }

    @Test
    public void Should_Pass_When_parseCommand_AddTwoDriver() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Driver Alex");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(2, database.size());
        assertEquals("Dan", database.get("Dan").getDriverName());
        assertEquals("Alex", database.get("Alex").getDriverName());
    }

    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver_And_OneTrip() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(1, database.size());
        assertEquals("Dan", database.keySet().toArray()[0]);
        assertEquals(1, database.get("Dan").getDriverTrips().size());
    }

    @Test(expected = DriverNotFoundException.class)
    public void Should_Throw_When_parseCommand_AddOneDriver_And_OneTripForAbsentDriver() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Alex 07:15 07:45 17.3");

        //Assert
    }

    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver_And_TwoTrips() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");
        console.parseCommand("Trip Dan 06:12 06:32 21.8");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(1, database.size());
        assertEquals("Dan", database.keySet().toArray()[0]);
        assertEquals(2, database.get("Dan").getDriverTrips().size());
    }
}