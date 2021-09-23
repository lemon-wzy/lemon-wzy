package shiro.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lichi
 */

@Slf4j
public class ScheduledJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("schedule job1 is running {}  {}",jobExecutionContext.getTrigger().getJobDataMap().get("taskId"),jobExecutionContext.getJobInstance().toString());
        //根据taskId去数据库获取响应信息，进行执行
        //todo 业务代码
        log.info("this is data  {}",jobExecutionContext.getTrigger().getJobDataMap().get("taskName"));

    }
}
