package com.adpushup.takeHomeTest.app;

import com.adpushup.takeHomeTest.siteRevenue.WebsiteRevenue;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class FileParserTask implements Callable<WebsiteRevenue> {
    private final File file;
    public FileParserTask(File file){
        this.file = file;
    }
    @Override
    public WebsiteRevenue call() throws Exception {
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        String[] nextRecord;
        long totalRevenueOfThisSite=0l;

        String siteName = file.getName().strip().substring(0, file.getName().indexOf('.'));

        Map<String, Long> advetiserRevenueMap= new HashMap<>();

        while((nextRecord = csvReader.readNext()) != null){
            String advitiserID= nextRecord[0].strip();
            long revenue = Long.valueOf(nextRecord[1].strip());
            totalRevenueOfThisSite+= revenue;
            if(advetiserRevenueMap.containsKey(advitiserID) ){
                revenue += advetiserRevenueMap.get(advitiserID);
            }
            advetiserRevenueMap.put(advitiserID,revenue);
        }

        return WebsiteRevenue.builder().
                forSiteName(siteName).
                withTotalRevenue(totalRevenueOfThisSite).
                setAdviterIdWiseMap(advetiserRevenueMap).
                build();
    }
}
