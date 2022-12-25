package com.adpushup.takeHomeTest.siteRevenue;

import lombok.Getter;

import java.util.Map;

@Getter
public class WebsiteRevenue {
    private String siteName;
    private Long totalSiteRevenue;
    private Map<String, Long> advertiserIdRevenueMap;

    private WebsiteRevenue(){

    }

    public static  SiteWiseRevenueBuilder builder(){
        return new SiteWiseRevenueBuilder();
    }

    public String getSiteName(){
        return this.siteName;
    }
    public Long getTotalSiteRevenue(){
        return this.totalSiteRevenue;
    }

    public Map<String, Long> getAdvertiserIdRevenueMap() {
        return this.advertiserIdRevenueMap;
    }

    public  static class SiteWiseRevenueBuilder{
        WebsiteRevenue siteWiseRevenue = new WebsiteRevenue();

        public SiteWiseRevenueBuilder forSiteName(String siteName){
            siteWiseRevenue.siteName= siteName;
            return this;
        }


        public SiteWiseRevenueBuilder withTotalRevenue(Long totalRevenue){
            siteWiseRevenue.totalSiteRevenue = totalRevenue;
            return this;
        }

        public SiteWiseRevenueBuilder setAdviterIdWiseMap(Map<String , Long> adviterIdWiseMap){
            siteWiseRevenue.advertiserIdRevenueMap = adviterIdWiseMap;
            return this;
        }

        public WebsiteRevenue build(){
            return this.siteWiseRevenue;
        }

    }
}
