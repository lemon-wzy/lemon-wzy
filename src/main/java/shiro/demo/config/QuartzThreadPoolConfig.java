package shiro.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lichi
 */
@Configuration
@Slf4j
public class QuartzThreadPoolConfig {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Bean
    @Order(2)
    public SchedulerFactoryBean getSchedulerFactoryBean() throws IOException {
        if(threadPoolTaskExecutor == null){
            log.error("threadPoolTaskExecutor is null");
            System.exit(0);
        }
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/config/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        //创建SchedulerFactoryBean
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setTaskExecutor(threadPoolTaskExecutor);
        factory.setQuartzProperties(propertiesFactoryBean.getObject());
        //这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
        factory.setWaitForJobsToCompleteOnShutdown(true);
        factory.setOverwriteExistingJobs(false);
        factory.setStartupDelay(1);
        return factory;
    }

    @Bean("taskExecutor")
    @Primary
    @Order(1)
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setCorePoolSize(2);
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.error("线程池超过最大容量,进行扩容 {} ",executor.getPoolSize());
                executor.setMaximumPoolSize(10);
                Thread thread = new Thread(r);
                thread.start();
                log.error(r.toString());
            }
        };
        threadPoolTaskExecutor.setRejectedExecutionHandler(handler);
        return threadPoolTaskExecutor;
    }


}
