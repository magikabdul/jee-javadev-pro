package pl.training.cdi.events;

import lombok.Setter;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Reception;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Setter
public class MessageConsumer {

    @Inject
    private Logger logger;

    public void onMessage(@Observes(notifyObserver = Reception.ALWAYS) String message) {
        logger.log(Level.INFO, "New message: " + message);
    }

}
