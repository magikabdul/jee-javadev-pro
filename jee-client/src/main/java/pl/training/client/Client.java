package pl.training.client;

import lombok.extern.java.Log;
import pl.training.jee.IdGenerator;
import pl.training.jee.PowerService;
import pl.training.jee.PropertiesStore;
import pl.training.jee.TimeProvider;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Log
public class Client {

    private static final String TIME_PROVIDER_JNDI_NAME = "java:/jee/SystemTimeProvider!pl.training.jee.TimeProvider";
    private static final String ID_GENERATOR_JNDI_NAME = "java:/jee/UUIDIdGenerator!pl.training.jee.IdGenerator";
    private static final String PROPERTIES_STORE_JNDI_NAME = "java:/jee/MapPropertiesStore!pl.training.jee.PropertiesStore";
    private static final String POWER_SERVICE_JNDI_NAME = "java:/jee/AsyncPowerService!pl.training.jee.PowerService";
    private static final String CONNECTION_FACTORY_JNDI_NAME = "jms/RemoteConnectionFactory";
    private static final String MESSAGES_TOPIC_JNDI_NAME = "jms/topic/Messages";
    private static final String LANGUAGE_KEY = "language";

    public static void main(String[] args) throws NamingException, ExecutionException, InterruptedException, TimeoutException {
        var proxyFactory = new ProxyFactory();
        TimeProvider timeProvider = proxyFactory.createProxy(TIME_PROVIDER_JNDI_NAME);
        IdGenerator idGenerator = proxyFactory.createProxy(ID_GENERATOR_JNDI_NAME);
        PropertiesStore propertiesStore = proxyFactory.createProxy(PROPERTIES_STORE_JNDI_NAME);
        PowerService powerService = proxyFactory.createProxy(POWER_SERVICE_JNDI_NAME);
        ConnectionFactory connectionFactory = proxyFactory.createProxy(CONNECTION_FACTORY_JNDI_NAME);
        Topic topic = proxyFactory.createProxy(MESSAGES_TOPIC_JNDI_NAME);
        //--------------------------------------------------------------------
        log.info("### Current timestamp: " + timeProvider.getTimestamp());
        log.info("### Id : " + idGenerator.getNext());
        propertiesStore.put(LANGUAGE_KEY, "java");
        log.info("### Language: " + propertiesStore.get(LANGUAGE_KEY));
        propertiesStore.close();
        var result = powerService.calculate(3L);
        log.info("### Is done: " + result.isDone());
        log.info("### Power: " + result.get(10, TimeUnit.SECONDS));
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(topic, "Hello JMS!");
        }
    }


}
