package pl.training.cdi.events;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

public class MessageProducer {

    @Inject
    private Event<String> eventEmitter;

    public void send(String message) {
        eventEmitter.fire(message);
    }

}
