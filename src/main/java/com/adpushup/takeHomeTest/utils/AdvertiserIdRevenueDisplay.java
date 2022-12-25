package com.adpushup.takeHomeTest.utils;

import java.util.Iterator;
import java.util.Map;

public class AdvertiserIdRevenueDisplay {

    public static void displayAdvertiserIdRevenue(Map<String, Long> advertiserRevenue){
        System.out.println("Total revenue for each advertiserId:");

        for (Iterator<Map.Entry<String, Long>> iterator = advertiserRevenue.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Long> entry = iterator.next();
            String advertiserId = entry.getKey();
            Long revenue = entry.getValue();
            System.out.println(advertiserId + ": INR " + revenue);
        }
    }

}
