package pl.training.cdi.decorator;

import lombok.Setter;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import pl.training.cdi.di.Car;
import pl.training.cdi.di.Vehicle;

import java.util.logging.Level;
import java.util.logging.Logger;

@Setter
@Decorator
public abstract class SmartCar implements Vehicle {

    @Delegate
    @Inject
    private Car car;
    @Inject
    private Logger logger;

    @Override
    public void drive() {
        logger.log(Level.INFO, "Turn on lights...");
        car.drive();
    }

}
