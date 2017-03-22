package com.sl.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 执行的job
 * Created by braveup on 2017/3/22.
 */
public class MyJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("my frist job ******************>>>>");
    }
}
