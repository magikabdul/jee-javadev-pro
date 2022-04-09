package pl.training.jee;

import java.util.Optional;

public interface PropertiesStore {

    void put(String key, String value);

    String get(String key);

    void close();

}
