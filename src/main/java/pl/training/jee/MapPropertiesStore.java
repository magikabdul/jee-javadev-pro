package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import java.util.Optional;

@Stateful
@Log
public class MapPropertiesStore implements PropertiesStore {

    @Override
    public void put(String key, String value) {

    }

    @Override
    public Optional<String> get(String key) {
        return Optional.empty();
    }

    @PrePassivate
    public void prePassivate() {
        log.info(getClass().getSimpleName() + " is passivating");
    }

    @PostActivate
    public void postActivate() {
        log.info(getClass().getSimpleName() + " is activaing");
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
