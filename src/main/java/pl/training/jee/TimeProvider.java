package pl.training.jee;

import javax.ejb.Lock;
import javax.ejb.LockType;
import java.time.LocalDateTime;

public interface TimeProvider {
    @Lock(LockType.READ)
    LocalDateTime getTimestamp();
}
