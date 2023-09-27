package ar.com.bds.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.TimeZone;

@Configuration
@EnableAsync
public class SpringBootConfig {

    @Value("${spring.jackson.time-zone}")
    private String defaultTimeZone;

    private static final Duration readTimeOut = Duration.ofSeconds(60);

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone(defaultTimeZone));
    }

    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder builder){
        return builder.setReadTimeout(readTimeOut).build();
    }



}
