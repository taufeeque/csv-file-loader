package com.adpushup.takeHomeTest.utils;

import java.util.Iterator;
import java.util.Map;

public class WebsiteRevenueDisplay {

    public static void displayRevenue(Map<String, Long> websiteRevenue){

        System.out.println("Total revenue for each website:");
        Long totalRevenueAcrossWebsite=0l;
        for(Iterator<Map.Entry<String, Long>> iterator = websiteRevenue.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<String, Long> entry = iterator.next();
            String website = entry.getKey();
            Long revenue = entry.getValue();
            totalRevenueAcrossWebsite += revenue;

            System.out.println(website + ": INR " + revenue );
        }
        System.out.println("Total revenue across  all website: "+" INR "+ totalRevenueAcrossWebsite);
    }
}
