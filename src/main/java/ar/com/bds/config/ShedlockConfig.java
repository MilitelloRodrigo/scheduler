package ar.com.bds.config;

import com.mongodb.client.MongoClient;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShedlockConfig {

    public static LockProvider lockProvider;

    @Bean
    public static LockProvider lockProvider(MongoClient mongoClient) {
        lockProvider = new MongoLockProvider(mongoClient.getDatabase("Locks"));
        return lockProvider;
    }

}
