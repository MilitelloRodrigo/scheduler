package ar.com.bds.service.impl;

import ar.com.bds.model.JobBDs;
import ar.com.bds.repository.JobRepository;
import ar.com.bds.service.CronService;
import ar.com.bds.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository repository;
    @Autowired
    private CronService cronService;

    @Override
    public void createJob(JobBDs jobBDs) throws SchedulerException {
        repository.save(jobBDs);
        if(jobBDs.isEnable()){
            cronService.initJob(jobBDs);
        }
    }
}
