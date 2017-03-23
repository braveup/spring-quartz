package com.sl.job.scheduler;

import com.sl.job.jobs.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Created by braveup on 2017/3/23.
 */
public class CronScheduler {
    public static void main(String[] args) {
        excute();
    }
    private static void excute(){
        //通过一个SchedulerFactory创建一个Scheduler
        SchedulerFactory factory=new StdSchedulerFactory();
        try {
            Scheduler scheduler=factory.getScheduler();
            //创建一个jobDetail，绑定job。调度器不能直接操作job实例
            //指定job的名称，所在的组，以及绑定的job类
            JobDetail jobDetail=new JobDetail("myjob","group", MyJob.class);
            //定义触发器
            //每5秒触发一次
            String cronExpression="*/5 * * * * ?";
            Trigger  cronTrigger=new CronTrigger("cronTrigger",Scheduler.DEFAULT_GROUP,cronExpression);
            //注册jobDetail和触发器到调度任务中去
            scheduler.scheduleJob(jobDetail,cronTrigger);
            //启动
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
