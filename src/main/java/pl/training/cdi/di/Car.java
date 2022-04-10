package pl.training.cdi.di;

import lombok.Setter;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import pl.training.cdi.interceptor.Measure;

import java.util.logging.Level;
import java.util.logging.Logger;

@Measure
@Setter
public class Car implements Vehicle {

    private Engine engine;
    @Inject
    private Logger logger;

    @Inject
    public void setEngine(@Motor(type = "diesel") Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    public void init() {
        logger.log(Level.INFO, "Engine is set");
    }

    @Override
    public void drive() {
        engine.start();
        logger.log(Level.INFO, "==================================>");
    }

    @Override
    public void stop() {
        logger.log(Level.INFO, "Stopped...");
    }

}
