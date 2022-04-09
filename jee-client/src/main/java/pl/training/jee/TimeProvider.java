package pl.training.jee;

import javax.ejb.Remote;
import java.time.LocalDateTime;

@Remote
public interface TimeProvider {

    LocalDateTime getTimestamp();

}
