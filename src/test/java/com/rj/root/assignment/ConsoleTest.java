package com.rj.root.assignment;

import com.rj.root.assignment.exceptions.DriverNotFoundException;
import com.rj.root.assignment.exceptions.FileNameNotGivenException;
import com.rj.root.assignment.exceptions.ImproperCommandException;
import com.rj.root.assignment.model.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleTest {

    private Console console;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() throws Exception {
        console = new Console();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() throws Exception {
        System.setOut(null);
    }

    @Test
    public void YouShallAlwaysPass() throws Exception {
        //Arrange
        //Act
        //Assert
        assertTrue(true);
    }

    @Test
    public void Should_Pass_Initially_DataBaseSizeIsEmpty() throws Exception {
        //Arrange

        //Act
        boolean isDatabaseEmpty = console.getDataBase().isEmpty();

        //Assert
        assertTrue(isDatabaseEmpty);
    }


    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver() throws Exception {
        //Arrange
        int expectedDatabaseSize = 1;
        String expectedDriverName = "Dan";

        //Act
        console.parseCommand("Driver Dan");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(expectedDatabaseSize, database.size());
        String key = database.keySet().toArray(new String[0])[0];
        assertEquals(expectedDriverName, database.get(key).getDriverName());
    }

    @Test(expected = ImproperCommandException.class)
    public void Should_Throw_When_parseCommand_RandomText() throws Exception {
        //Arrange

        //Act
        console.parseCommand("Hello Dan");

        //Assert
    }

    @Test
    public void Should_Pass_When_parseCommand_AddTwoDriver() throws Exception {
        //Arrange
        int expectedDatabaseSize = 2;
        String expectedDriverName_1 = "Dan";
        String expectedDriverName_2 = "Alex";


        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Driver Alex");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(expectedDatabaseSize, database.size());

        String key_1 = database.keySet().toArray(new String[0])[0];
        assertEquals(expectedDriverName_1, database.get(key_1).getDriverName());

        String key_2 = database.keySet().toArray(new String[1])[1];
        assertEquals(expectedDriverName_2, database.get(key_2).getDriverName());
    }

    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver_And_OneTrip() throws Exception {
        //Arrange
        int expectedDatabaseSize = 1;
        String expectedDriverName = "Dan";
        int expectedTripsSize = 1;

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(expectedDatabaseSize, database.size());
        assertEquals(expectedDriverName, database.keySet().toArray()[0]);
        assertEquals(expectedTripsSize, database.get("Dan").getDriverTrips().size());
    }

    @Test(expected = DriverNotFoundException.class)
    public void Should_Throw_When_parseCommand_AddOneDriver_And_OneTripForAbsentDriver() throws Exception {
        //Arrange

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Alex 07:15 07:45 17.3");

        //Assert
    }

    @Test
    public void Should_Pass_When_parseCommand_AddOneDriver_And_TwoTrips() throws Exception {
        //Arrange
        int expectedDatabaseSize = 1;
        String expectedDriverName = "Dan";
        int expectedTripsSize = 2;

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");
        console.parseCommand("Trip Dan 06:12 06:32 21.8");

        //Assert
        HashMap<String, Driver> database = console.getDataBase();
        assertEquals(expectedDatabaseSize, database.size());
        assertEquals(expectedDriverName, database.keySet().toArray()[0]);
        assertEquals(expectedTripsSize, database.get("Dan").getDriverTrips().size());
    }


    @Test
    public void Should_Pass_When_printReport_With_SingleDriver_And_SingleTrip() throws Exception {
        //Arrange
        String expectedOutPut = "Alex: 42 miles @ 34 mph\n";

        //Act
        console.parseCommand("Driver Alex");
        console.parseCommand("Trip Alex 12:01 13:16 42.0");
        console.printReport();

        //Assert
        assertEquals(expectedOutPut, outContent.toString());
    }

    @Test
    public void Should_Pass_When_printReport_With_SingleDriver_And_MultipleTrips() throws Exception {
        //Arrange
        String expectedOutPut = "Dan: 39 miles @ 47 mph\n";

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");
        console.parseCommand("Trip Dan 06:12 06:32 21.8");
        console.printReport();

        //Assert
        assertEquals(expectedOutPut, outContent.toString());
    }

    @Test
    public void Should_Pass_When_printReport_With_MultipleDriver_And_MultipleTrips() throws Exception {
        //Arrange
        String expectedOutPut = "Alex: 42 miles @ 34 mph\nDan: 39 miles @ 47 mph\nBob: 0 miles\n";

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Driver Alex");
        console.parseCommand("Driver Bob");
        console.parseCommand("Trip Dan 07:15 07:45 17.3");
        console.parseCommand("Trip Dan 06:12 06:32 21.8");
        console.parseCommand("Trip Alex 12:01 13:16 42.0");
        console.printReport();

        //Assert
        assertEquals(expectedOutPut, outContent.toString());
    }

    @Test
    public void Should_Pass_Invoking_Main_With_File_Name() throws Exception {
        //Arrange
        String expectedOutPut = "Alex: 42 miles @ 34 mph\nDan: 39 miles @ 47 mph\nBob: 0 miles\n";

        //Act
        final String currentDir = System.getProperty("user.dir");
        Console.main(new String[]{currentDir + "/input.txt"});

        //Assert
        assertEquals(expectedOutPut, outContent.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void Should_Throw_Invoking_Main_With_Absent_File_Name() throws Exception {
        //Arrange

        //Act
        final String currentDir = System.getProperty("user.dir");
        Console.main(new String[]{currentDir + "/fileNotFound.txt"});

        //Assert
    }

    @Test(expected = FileNameNotGivenException.class)
    public void Should_Throw_Invoking_Main_Without_Any_File_Name() throws Exception {
        //Arrange

        //Act
        Console.main(new String[]{""});

        //Assert
    }

    @Test(expected = FileNameNotGivenException.class)
    public void Should_Throw_Invoking_Main_Without_Null_File_Name() throws Exception {
        //Arrange

        //Act
        Console.main(new String[]{null});

        //Assert
    }
}