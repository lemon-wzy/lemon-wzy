package shiro.demo.component;

/**
 * @author lichi
 */

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import shiro.demo.entity.QuartzTask;
import shiro.demo.job.ScheduledJob;
import shiro.demo.mapper.QuartzMapper;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SchedulerAllJob {

    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;
    @Resource
    private QuartzMapper quartzMapper;

    /*
     * 此处可以注入数据库操作，查询出所有的任务配置
     */

    /**
     * 该方法用来启动所有的定时任务
     * @throws SchedulerException
     */
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

//        scheduleJob1(scheduler);

    }

    public void stop() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        scheduler.clear();
    }

    public void remove(int i) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        boolean deleteJob = scheduler.deleteJob(new JobKey("job" + i, "group1"));
        System.out.println(deleteJob);
    }

    public void add(int i) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity("job" + i, "group1").build();
        // 每5s执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job" + i, "group1") .withSchedule(scheduleBuilder).build();
        cronTrigger.getJobDataMap().put("taskId",i);
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    /**
     * 配置Job1
     * 此处的任务可以配置可以放到properties或者是放到数据库中
     * @param scheduler
     * @throws SchedulerException
     */
    private void scheduleJob1(Scheduler scheduler) throws SchedulerException{
//        Wrapper<QuartzTask> wrapper = new EntityWrapper<>();
        QueryWrapper<QuartzTask> queryWrapper = new QueryWrapper<>();
        List<QuartzTask> tasks = quartzMapper.selectList(queryWrapper);

        if(tasks != null && !tasks.isEmpty()){
            for (QuartzTask task : tasks) {
                JobKey jobKey = new JobKey(task.getJobName(), task.getJobGroup());
                JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class) .withIdentity(jobKey).build();
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getQuartzTime());
//                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
                CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(task.getJobName(), task.getJobGroup()) .withSchedule(scheduleBuilder).build();
                cronTrigger.getJobDataMap().put("taskId", task.getId());
                cronTrigger.getJobDataMap().put("taskName",task.getJobName());
                if (!scheduler.checkExists(jobKey)) {
                    scheduler.scheduleJob(jobDetail,cronTrigger);
                }
            }

        }

    }

}
