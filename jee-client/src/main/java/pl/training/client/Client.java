package pl.training.client;

import lombok.extern.java.Log;
import pl.training.jee.IdGenerator;
import pl.training.jee.PropertiesStore;
import pl.training.jee.TimeProvider;

import javax.naming.NamingException;

@Log
public class Client {

    private static final String TIME_PROVIDER_JNDI_NAME = "java:/jee-example-1.0-SNAPSHOT/SystemTimeProvider!pl.training.jee.TimeProvider";
    private static final String ID_GENERATOR_JNDI_NAME = "java:/jee-example-1.0-SNAPSHOT/UUIDIdGenerator!pl.training.jee.IdGenerator";
    private static final String PROPERTIES_STORE_JNDI_NAME = "java:/jee-example-1.0-SNAPSHOT/MapPropertiesStore!pl.training.jee.PropertiesStore";
    private static final String LANGUAGE_KEY = "language";

    public static void main(String[] args) throws NamingException {
        var proxyFactory = new ProxyFactory();
        TimeProvider timeProvider = proxyFactory.createProxy(TIME_PROVIDER_JNDI_NAME);
        IdGenerator idGenerator = proxyFactory.createProxy(ID_GENERATOR_JNDI_NAME);
        PropertiesStore propertiesStore = proxyFactory.createProxy(PROPERTIES_STORE_JNDI_NAME);
        //--------------------------------------------------------------------
        log.info("### Current timestamp: " + timeProvider.getTimestamp());
        log.info("### Id : " + idGenerator.getNext());
        propertiesStore.put(LANGUAGE_KEY, "java");
        log.info("### Language: " + propertiesStore.get(LANGUAGE_KEY));
        propertiesStore.close();
    }


}
