package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.time.LocalDateTime;

@Startup
@Singleton
@Log
public class SystemTimeProvider implements TimeProvider {

    @Interceptors(TimerInterceptor.class)
    @Override
    @Lock(LockType.READ)
    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
    public void printTime() {
        log.info("### Current timestamp: " + getTimestamp());
    }

    @PostConstruct
    public void postConstruct(){
        log.info(getClass().getSimpleName() + ": postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info(getClass().getSimpleName() + ": preDestroy");
    }

}
