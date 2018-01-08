package com.rj.root.assignment.utils;

import com.rj.root.assignment.model.Driver;

import java.util.*;

public class SortUtils {

    public static HashMap<String, Driver> sortDatabase(HashMap<String, Driver> unSortedMap) {

        List<Map.Entry<String, Driver>> list = new LinkedList<>(unSortedMap.entrySet());

        // Sorting the list based on values
        list.sort(Comparator.comparing(o -> 1 / o.getValue().getTotalJourneyDistanceInMiles()));

        // Maintaining insertion order with the help of LinkedList
        HashMap<String, Driver> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Driver> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}