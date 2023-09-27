package ar.com.bds.service;

import ar.com.bds.model.JobBDs;
import org.quartz.SchedulerException;

public interface CronService {

    void initJob(JobBDs jobBDs) throws SchedulerException;
}
