package pl.training.shop.payments;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.mapstruct.factory.Mappers;
import pl.training.shop.payments.adapters.persistence.JpaPersistencePaymentMapper;
import pl.training.shop.payments.adapters.rest.RestPaymentMapper;
import pl.training.shop.payments.domain.DefaultPaymentFactory;
import pl.training.shop.payments.ports.IdGenerator;
import pl.training.shop.payments.ports.PaymentFactory;
import pl.training.shop.payments.ports.PaymentRepository;
import pl.training.shop.payments.ports.PaymentService;

@Singleton
public class PaymentsConfiguration {

    private static final PaymentFactory PAYMENT_FACTORY = new DefaultPaymentFactory();

    @Singleton
    @Produces
    public JpaPersistencePaymentMapper jpaPersistencePaymentMapper() {
        return Mappers.getMapper(JpaPersistencePaymentMapper.class);
    }

    @Singleton
    @Produces
    public PaymentService paymentService(IdGenerator idGenerator, PaymentRepository paymentRepository) {
        return PAYMENT_FACTORY.paymentsService(idGenerator, paymentRepository);
    }

    @Singleton
    @Produces
    public RestPaymentMapper restPaymentMapper() {
        return Mappers.getMapper(RestPaymentMapper.class);
    }

}
