package pl.training.jee;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

@Stateful
@Log
public class MapPropertiesStore implements PropertiesStore {

    private final Map<String, String> properties = new HashMap<>();

    @Override
    public void put(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String get(String key) {
        return properties.get(key);
    }

    @Remove
    @Override
    public void close() {
    }

    @PrePassivate
    public void prePassivate() {
        log.info(getClass().getSimpleName() + ": prePassivate");
    }

    @PostActivate
    public void postActivate() {
        log.info(getClass().getSimpleName() + ": postActivate");
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
