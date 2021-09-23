package shiro.demo.controller;


import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shiro.demo.component.SchedulerAllJob;

/**
 * @author lichi
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    public SchedulerAllJob myScheduler;

    @RequestMapping("/start")
    public String schedule() throws SchedulerException {

        myScheduler.scheduleJobs();

        return "success";
    }

    @RequestMapping("/stop")
    public String stop() throws SchedulerException {

        myScheduler.stop();

        return "success";
    }

    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) throws SchedulerException {

        myScheduler.add(id);

        return "success";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id) throws SchedulerException {

        myScheduler.remove(id);

        return "success";
    }

}
