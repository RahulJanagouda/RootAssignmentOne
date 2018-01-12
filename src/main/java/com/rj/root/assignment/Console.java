package com.rj.root.assignment;

import com.rj.root.assignment.exceptions.DriverNotFoundException;
import com.rj.root.assignment.exceptions.FileNameNotGivenException;
import com.rj.root.assignment.exceptions.ImproperCommandException;
import com.rj.root.assignment.model.Driver;
import com.rj.root.assignment.utils.SortUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
    private HashMap<String, Driver> driverDatabase = new HashMap<>();

    public static void main(String[] args) throws FileNameNotGivenException, FileNotFoundException {
        Console console = new Console();
        Scanner scanner = null;

        if (args[0] == null || args[0].equals("")) {
            throw new FileNameNotGivenException("Please mention a file as an input.");
        }

        try {
            scanner = new Scanner(new FileReader(args[0]));
            while (scanner.hasNext())
                console.parseCommand(scanner.nextLine());
            console.printReport();
        } catch (FileNotFoundException e) {
            System.out.println("The given file does not exist at location:" + args[0]);
            System.out.println("Please give absolute path to the file location");
            throw e;
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    void parseCommand(String command) {
        if (command.startsWith("Driver")) {
            parseDriver(command.split(" ")[1]);
        } else if (command.startsWith("Trip")) {
            String[] tripCommand = command.split(" ");
            parseTrip(tripCommand[1], tripCommand[2], tripCommand[3], tripCommand[4]);
        } else {
            throw new ImproperCommandException("Unknown Command: " + command);
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

    HashMap<String, Driver> getDataBase() {
        return driverDatabase;
    }

    void printReport() {
        for (Map.Entry<String, Driver> driver : SortUtils.sortDatabase(driverDatabase).entrySet()) {
            System.out.println(driver.getValue().toString());
        }

    }
}
