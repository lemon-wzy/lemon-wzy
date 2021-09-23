package shiro.demo.component;

/**
 * @author lichi
 */

import org.quartz.SchedulerException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class QuartzInitLisenter implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private SchedulerAllJob schedulerAllJob;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            schedulerAllJob.scheduleJobs();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        System.out.println("ssssss>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
}
