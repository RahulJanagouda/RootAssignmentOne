package com.rj.root.assignment.model;

import com.rj.root.assignment.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String driverName;
    private List<Trip> driverTrips;

    // These variables are used to enhance the performance while calculating Average Speed.
    // Instead of iterating through all the trips and calculating it is better to compute
    // these when adding a new trip.
    private Float totalJourneyTimeInHour;
    private Float totalJourneyDistanceInMiles;


    public Driver(String driverName) {
        setDriverName(driverName);
        driverTrips = new ArrayList<>();
        totalJourneyTimeInHour = 0f;
        totalJourneyDistanceInMiles = 0f;
    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public List<Trip> getDriverTrips() {
        return driverTrips;
    }

    public void addTrip(String startTime, String endTime, String distanceInMiles) {
        driverTrips.add(new Trip(startTime, endTime, distanceInMiles));

        // pre calculate to for better performance
        setTotalJourneyTimeInHour(getTotalJourneyTimeInHour() + DateUtils.differenceInHours(startTime, endTime));
        setTotalJourneyDistanceInMiles(getTotalJourneyDistanceInMiles() + Float.parseFloat(distanceInMiles));
    }

    public Float getTotalJourneyTimeInHour() {
        return totalJourneyTimeInHour;
    }

    public void setTotalJourneyTimeInHour(Float totalJourneyTimeInHour) {
        this.totalJourneyTimeInHour = totalJourneyTimeInHour;
    }

    public Float getTotalJourneyDistanceInMiles() {
        return totalJourneyDistanceInMiles;
    }

    public void setTotalJourneyDistanceInMiles(Float totalJourneyDistanceInMiles) {
        this.totalJourneyDistanceInMiles = totalJourneyDistanceInMiles;
    }
}
