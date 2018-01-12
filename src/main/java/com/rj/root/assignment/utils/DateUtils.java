package com.rj.root.assignment.utils;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

public class DateUtils {
    public static DateTime convertStringToDate(String inputString) {
        int hours = Integer.parseInt(inputString.split(":")[0]);
        int minutes = Integer.parseInt(inputString.split(":")[1]);
        return new DateTime()
                .withHourOfDay(hours)
                .withMinuteOfHour(minutes)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);
    }

    public static float differenceInHours(String startTimeInString, String endTime) {
        DateTime startDateTime = convertStringToDate(startTimeInString);
        DateTime endDateTime = convertStringToDate(endTime);
        return Minutes.minutesBetween(startDateTime, endDateTime).getMinutes() / 60f;
    }

    public static float differenceInHours(DateTime startDateTime, DateTime endDateTime) {
        return Minutes.minutesBetween(startDateTime, endDateTime).getMinutes() / 60f;
    }
}
