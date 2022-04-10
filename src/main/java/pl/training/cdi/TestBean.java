package pl.training.cdi;

import jakarta.inject.Inject;
import lombok.extern.java.Log;
import pl.training.cdi.di.Car;
import pl.training.cdi.events.MessageProducer;
import pl.training.cdi.producer.RandomValue;

import java.util.logging.Logger;

@Log
public class TestBean {

    @Inject
    private Car car;
    @RandomValue
    @Inject
    private int randomInt;
    @Inject
    private String randomText;
    @Inject
    private Logger logger;
    @Inject
    private MessageProducer messageProducer;

    public void start() {
        car.drive();
        car.stop();
        logger.info("Random int: "  + randomInt);
        logger.info("Random text: "  + randomText);
        messageProducer.send("CDI is great!");
    }

}
