package ar.com.bds.service.impl;

import ar.com.bds.model.JobBDs;
import ar.com.bds.model.JobExecute;
import ar.com.bds.service.CronService;
import net.javacrumbs.shedlock.core.LockProvider;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class CronServiceImpl implements CronService {

    private final Scheduler scheduler;
    private final LockProvider lockProvider;

    public CronServiceImpl(LockProvider lockProvider) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        this.lockProvider = lockProvider;
    }

    @Override
    public void initJob(JobBDs jobBDs) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(JobExecute.class)
                .withIdentity(jobBDs.getName())
                .usingJobData("endpoint", jobBDs.getEndpoint())
                .usingJobData("method", jobBDs.getMethod().name())
                .usingJobData("name", jobBDs.getName())
                .build();
        String cronExpression = jobBDs.getCron();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
        // Programar la tarea
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
