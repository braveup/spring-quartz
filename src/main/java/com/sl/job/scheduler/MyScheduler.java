package com.sl.job.scheduler;

import com.sl.job.MyJob;
import com.sl.job.MyJobTwo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by braveup on 2017/3/22.
 */
public class MyScheduler {
    public static void main(String[] args) {
        myScheduler();
    }

    public static void myScheduler(){
        //通过schedulerFactory获取一个调度器
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler  scheduler=null;
        //通过schedulerFactory获取一个调度器
        try {
            scheduler=schedulerFactory.getScheduler();
            //创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail  jobDetail= new JobDetail("firstJob", "jroupone", MyJob.class);
            JobDetail  jobDetail2= new JobDetail("firstJob2", "jroupone2", MyJobTwo.class);
            //定义调度触发规则，比如每1秒运行一次，共运行8次
            SimpleTrigger  simpleTrigger=new SimpleTrigger("simpleTrigger","jroupone");
            SimpleTrigger  simpleTrigger2=new SimpleTrigger("simpleTrigger1","jroupone2");
            //启动
            simpleTrigger.setStartTime(new Date());
            //间隔时间
            simpleTrigger.setRepeatInterval(10);
            // 运行次数
            simpleTrigger.setRepeatCount(80);
            //  把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail,simpleTrigger);
            scheduler.scheduleJob(jobDetail2,simpleTrigger2);
            //启动调度
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
