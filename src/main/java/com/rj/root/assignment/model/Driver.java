package com.rj.root.assignment.model;

import com.rj.root.assignment.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String driverName;
    private List<Trip> driverTrips;

    // These variables are used to enhance the performance while calculating Average Speed.
    // Instead of iterating through all the trips and calculating it is better to compute
    // these when adding a new trip. This might not make a difference for small inputs but
    // surely this will play a major role when the input size is huge.
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

    void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public List<Trip> getDriverTrips() {
        return driverTrips;
    }

    public void addTrip(String startTime, String endTime, String distanceInMiles) {

        // After clarifying with Clara, it is understood that I should ignore trips with average speed of less than 5 mph or greater than 100 mph.
        // "Discard any trips that average a speed of less than 5 mph or greater than 100 mph."
        // Here is where we ignore the trips for the calculation.

        Trip tripToInsert = new Trip(startTime, endTime, distanceInMiles);

        if (tripToInsert.getRoundedSpeed() > 5 && tripToInsert.getRoundedSpeed() < 100) {
            driverTrips.add(tripToInsert);

            // This technique is to pre calculate every time a new trip is added which provides better performance for large data sets.

            setTotalJourneyTimeInHour(getTotalJourneyTimeInHour() + DateUtils.differenceInHours(startTime, endTime));
            setTotalJourneyDistanceInMiles(getTotalJourneyDistanceInMiles() + Float.parseFloat(distanceInMiles));
        }
    }

    Float getTotalJourneyTimeInHour() {
        return totalJourneyTimeInHour;
    }

    void setTotalJourneyTimeInHour(Float totalJourneyTimeInHour) {
        this.totalJourneyTimeInHour = totalJourneyTimeInHour;
    }

    public Float getTotalJourneyDistanceInMiles() {
        return totalJourneyDistanceInMiles;
    }

    public void setTotalJourneyDistanceInMiles(Float totalJourneyDistanceInMiles) {
        this.totalJourneyDistanceInMiles = totalJourneyDistanceInMiles;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int roundedMilesPerHour = Math.round(getTotalJourneyDistanceInMiles() / getTotalJourneyTimeInHour());

        if (roundedMilesPerHour > 0) {
            stringBuilder
                    .append(getDriverName())
                    .append(": ")
                    .append(Math.round(getTotalJourneyDistanceInMiles()))
                    .append(" miles @ ")
                    .append(roundedMilesPerHour)
                    .append(" mph");
        } else {
            stringBuilder
                    .append(getDriverName())
                    .append(": ")
                    .append(Math.round(getTotalJourneyDistanceInMiles()))
                    .append(" miles");
        }
        return stringBuilder.toString();
    }

}
