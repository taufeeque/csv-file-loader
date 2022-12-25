package com.adpushup.takeHomeTest.app;

import com.adpushup.takeHomeTest.siteRevenue.WebsiteRevenue;
import com.adpushup.takeHomeTest.utils.AdvertiserIdRevenueDisplay;
import com.adpushup.takeHomeTest.utils.WebsiteRevenueDisplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class RevenueCalculator {

    public void calculateRevenue(List<Future<WebsiteRevenue>> futureSiteWiseRevenueList){


        Map<String, Long> websiteRevenue = new HashMap<>();
        Map<String, Long> advertiserRevenue = new HashMap<>();

        for (Future<WebsiteRevenue> future : futureSiteWiseRevenueList) {
            try {
                WebsiteRevenue result = future.get();
                websiteRevenue.put(result.getSiteName(), result.getTotalSiteRevenue());
                for (Map.Entry<String, Long> entry : result.getAdvertiserIdRevenueMap().entrySet()) {
                    String advertiserId = entry.getKey();
                    Long revenue = entry.getValue();

                    Long totalAdvertiserRevenue = advertiserRevenue.get(advertiserId);
                    if (totalAdvertiserRevenue == null) {
                        totalAdvertiserRevenue = 0l;
                    }
                    totalAdvertiserRevenue += revenue;
                    advertiserRevenue.put(advertiserId, totalAdvertiserRevenue);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        WebsiteRevenueDisplay.displayRevenue(websiteRevenue);
        AdvertiserIdRevenueDisplay.displayAdvertiserIdRevenue(advertiserRevenue);

    }

    public static RevenueCalculator getInstance(){
        return new RevenueCalculator();
    }

}
