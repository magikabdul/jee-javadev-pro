package pl.training.cdi.di;

import lombok.Setter;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Setter
@Alternative
@Motor(type = "diesel")
public class TestEngine implements Engine {

    @Inject
    private Logger logger;

    @Override
    public void start() {
        logger.log(Level.INFO, "Test engine started...");
    }

}
