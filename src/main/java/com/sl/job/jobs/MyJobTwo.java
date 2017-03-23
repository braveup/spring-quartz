package com.sl.job.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by braveup on 2017/3/23.
 */
public class
MyJobTwo implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.printf("i am two ************>>>");
    }
}
