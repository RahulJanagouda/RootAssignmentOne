package com.rj.root.assignment.model;

import com.rj.root.assignment.utils.DateUtils;
import org.joda.time.DateTime;

public class Trip {
    private DateTime startTime;
    private DateTime endTime;
    private Float distanceInMiles;

    Trip(String startTime, String endTime, String distanceInMiles) {
        setStartTime(DateUtils.convertStringToDate(startTime));
        setEndTime(DateUtils.convertStringToDate(endTime));
        setDistanceInMiles(Float.parseFloat(distanceInMiles));
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Float getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(Float distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }
}
