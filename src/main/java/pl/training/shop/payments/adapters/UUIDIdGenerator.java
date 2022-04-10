package pl.training.shop.payments.adapters;

import jakarta.inject.Singleton;
import pl.training.shop.payments.ports.IdGenerator;

import java.util.UUID;

@Singleton
public class UUIDIdGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
