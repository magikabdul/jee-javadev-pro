package pl.training.shop;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.mapstruct.factory.Mappers;
import pl.training.shop.commons.FastMoneyMapper;

@Singleton
public class ShopConfiguration {

    @Singleton
    @Produces
    public FastMoneyMapper fastMoneyMapper() {
        return Mappers.getMapper(FastMoneyMapper.class);
    }

}
