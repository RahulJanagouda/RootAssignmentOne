package com.rj.root.assignment;

import com.rj.root.assignment.model.Driver;
import org.junit.Test;

import java.util.List;

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
    public void Should_Pass_When_parseCommand_AddOneDriver() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");

        //Assert
        List<Driver> database = console.getDataBase();
        assertEquals(1, database.size());
        assertEquals("Dan", database.get(0).getDriverName());
    }

    @Test
    public void Should_Pass_When_parseCommand_AddTwoDriver() throws Exception {
        //Arrange
        Console console = new Console();

        //Act
        console.parseCommand("Driver Dan");
        console.parseCommand("Driver Alex");

        //Assert
        List<Driver> database = console.getDataBase();
        assertEquals(2, database.size());
        assertEquals("Dan", database.get(0).getDriverName());
        assertEquals("Alex", database.get(1).getDriverName());
    }
}