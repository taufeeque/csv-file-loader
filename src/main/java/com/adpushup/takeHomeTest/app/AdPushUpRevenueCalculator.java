package com.adpushup.takeHomeTest.app;


import com.adpushup.takeHomeTest.exceptions.InvalidDirectoryException;
import com.adpushup.takeHomeTest.siteRevenue.WebsiteRevenue;
import com.adpushup.takeHomeTest.utils.DirectoryValidator;
import com.adpushup.takeHomeTest.utils.FileDetector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class AdPushUpRevenueCalculator implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        try {
            if (args.length > 0) {

                long startTime = System.currentTimeMillis();
                String INPUT_DIRECTORY = args[0];
                File directory = DirectoryValidator.validateDirectory(INPUT_DIRECTORY);

                if(null == directory){
                    System.out.println("Given Directory is not valid");
                    throw new InvalidDirectoryException("Given Directory is not valid: " + directory);
                }else if(!directory.canRead()){
                    System.out.println("Given Directory is not Readable");
                    throw new InvalidDirectoryException("Given Directory is not Readable: " + directory);
                }

                File[] files  = FileDetector.getAllCsvDirectory(directory);
                List<Future<WebsiteRevenue>>  futureSiteWiseRevenueList = FileExecutor.getInstance().processFiles(files);
                RevenueCalculator.getInstance().calculateRevenue(futureSiteWiseRevenueList);
                long endtime = System.currentTimeMillis();
                System.out.println("total time taken to calculate revenue from all csv files: "+ (endtime - startTime) +" ms");
            }else {

                System.out.println("Command Line Argument size is zero");
            }

            System.exit(0);

        } catch (Exception ex) {

            throw new Exception("Unable to get valid folder path", ex);
        }


    }
}
