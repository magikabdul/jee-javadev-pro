package pl.training.jee;

import javax.ejb.Remote;
import java.util.Optional;

@Remote
public interface PropertiesStore {

    void put(String key, String value);

    Optional<String> get(String key);

    void close();

}
