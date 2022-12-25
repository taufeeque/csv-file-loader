package com.adpushup.takeHomeTest.app;

import com.adpushup.takeHomeTest.siteRevenue.WebsiteRevenue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileExecutor {
    private ExecutorService executorService;
    private FileExecutor(){

        this.executorService = Executors.newFixedThreadPool(2*Runtime.getRuntime().availableProcessors());
    }

    public List<Future<WebsiteRevenue>> processFiles(File[] files) throws InterruptedException {

        List<Callable<WebsiteRevenue> > tasks = new ArrayList<>();
        for (File file : files) {
            Callable<WebsiteRevenue> task = new FileParserTask(file);
            tasks.add(task);

        }
        List<Future<WebsiteRevenue>> futureWebsiteRevenueList = executorService.invokeAll(tasks);
        executorService.shutdown();
        return futureWebsiteRevenueList;
    }

    public static FileExecutor getInstance(){
        return new FileExecutor();
    }

}
