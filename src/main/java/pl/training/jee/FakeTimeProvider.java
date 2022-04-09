package pl.training.jee;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.LocalDateTime;

//@Startup
//@Singleton
public class FakeTimeProvider implements TimeProvider {

    @Override
    public LocalDateTime getTimestamp() {
        return LocalDateTime.parse("2022-04-09T12:18:30.929501200");
    }

}
