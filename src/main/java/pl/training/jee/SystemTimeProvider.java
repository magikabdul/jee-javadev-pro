package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.time.LocalDateTime;

@Startup
@Singleton
@Log
public class SystemTimeProvider implements TimeProvider {

    @Override
    @Lock(LockType.READ)
    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    @PostConstruct
    public void postConstruct(){
        log.info(getClass().getSimpleName() + " is constructed");
    }

    @PreDestroy
    public void preDestroy() {
        log.info(getClass().getSimpleName() + " is going down");
    }

}
