package ar.com.bds.controller;

import ar.com.bds.model.JobBDs;
import ar.com.bds.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public void createJob(JobBDs jobBDs) throws SchedulerException {
        jobService.createJob(jobBDs);
    }
}
