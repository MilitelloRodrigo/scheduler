package ar.com.bds.service;

import ar.com.bds.model.JobBDs;
import org.quartz.SchedulerException;

public interface JobService {

    void createJob(JobBDs jobBDs) throws SchedulerException;
}
