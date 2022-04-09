package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
@Log
public class UUIDIdGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
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
