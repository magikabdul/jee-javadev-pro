package pl.training.cdi.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class Beans {

    private final Random random = new Random();

    // @Singleton
    @RandomValue
    @Produces
    public int getRandomInt() {
        return random.nextInt(101);
    }

    public void destroyRandomInt(@Disposes @RandomValue int value, Logger logger) {
        logger.log(Level.INFO, "Destroing int: " + value);
    }

    @Produces
    public String getRandomText(@RandomValue int randomInt) {
        return "Text" + randomInt;
    }

    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        String className = injectionPoint.getMember().getDeclaringClass().getName();
        return Logger.getLogger(className);
    }

}
