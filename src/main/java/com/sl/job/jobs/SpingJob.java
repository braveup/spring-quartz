package com.sl.job.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by braveup on 2017/3/23.
 */
public class SpingJob {

    private static int counter = 0;
    protected void execute()  {
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println("(" + counter++ + ")");
    }
}
