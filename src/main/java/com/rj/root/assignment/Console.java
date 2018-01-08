package com.rj.root.assignment;

import com.rj.root.assignment.exceptions.DriverNotFoundException;
import com.rj.root.assignment.exceptions.UnknownCommandException;
import com.rj.root.assignment.model.Driver;

import java.util.HashMap;

public class Console {
    private HashMap<String, Driver> driverDatabase = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello Root");
    }

    public void parseCommand(String command) {
        if (command.startsWith("Driver")) {
            parseDriver(command.split(" ")[1]);
        } else if (command.startsWith("Trip")) {
            String[] tripCommand = command.split(" ");
            parseTrip(tripCommand[1], tripCommand[2], tripCommand[3], tripCommand[4]);
        } else {
            throw new UnknownCommandException("Unknown Command: " + command);
        }
    }

    private void parseTrip(String driverName, String startTime, String endTime, String distanceInMiles) {
        try {
            getDataBase().get(driverName).addTrip(startTime, endTime, distanceInMiles);
        } catch (NullPointerException e) {
            throw new DriverNotFoundException("Driver not found: " + driverName);
        }
    }

    private void parseDriver(String driverName) {
        getDataBase().put(driverName, new Driver(driverName));
    }

    public HashMap<String, Driver> getDataBase() {
        return driverDatabase;
    }
}