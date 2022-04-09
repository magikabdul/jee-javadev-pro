package pl.training.jee;

import javax.ejb.Remote;

@Remote
public interface PropertiesStore {

    void put(String key, String value);

    String get(String key);

    void close();

}
