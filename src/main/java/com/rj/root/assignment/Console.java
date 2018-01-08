package com.rj.root.assignment;

import com.rj.root.assignment.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private List<Driver> driverDatabase = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello Root");
    }

    public void parseCommand(String command) {
        if (command.startsWith("Driver")) {
            addDriver(command.split(" ")[1]);
        }
    }

    private void addDriver(String driverName) {
        getDataBase().add(new Driver(driverName));
    }

    public List<Driver> getDataBase() {
        return driverDatabase;
    }
}
