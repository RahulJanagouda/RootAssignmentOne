package com.rj.root.assignment.model;

import com.rj.root.assignment.utils.DateUtils;
import org.joda.time.DateTime;

public class Trip {
    private DateTime startTime;
    private DateTime endTime;
    private Float distanceInMiles;
    private int roundedSpeed;

    Trip(String startTime, String endTime, String distanceInMiles) {
        setStartTime(DateUtils.convertStringToDate(startTime));
        setEndTime(DateUtils.convertStringToDate(endTime));
        setDistanceInMiles(Float.parseFloat(distanceInMiles));
        setRoundedSpeed(Math.round(getDistanceInMiles() / DateUtils.differenceInHours(startTime, endTime)));
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

    public int getRoundedSpeed() {
        return roundedSpeed;
    }

    public void setRoundedSpeed(int roundedSpeed) {
        this.roundedSpeed = roundedSpeed;
    }

}
