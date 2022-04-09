package pl.training.jee;

import java.util.Optional;

public interface PropertiesStore {

    void put(String key, String value);

    Optional<String> get(String key);

}
