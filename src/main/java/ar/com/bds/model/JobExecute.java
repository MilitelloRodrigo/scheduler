package ar.com.bds.model;

import ar.com.bds.config.ShedlockConfig;
import io.swagger.annotations.Scope;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockConfiguration;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SimpleLock;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@Setter
public class JobExecute implements Job {

    private String endpoint;
    private String method;
    private String name;
    private LockProvider lockProvider = ShedlockConfig.lockProvider;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        LockConfiguration lockConfig = new LockConfiguration(
                name,
                Instant.now()
        );
        Optional<SimpleLock> lock = this.lockProvider.lock(lockConfig);
        try {
            if (lock.isPresent()) {
                log.info("Ejecutando tarea programada para el endpooint {} y el metodo {}", endpoint, method);
            }
        } finally {
            lock.get().unlock();
        }
    }

}
