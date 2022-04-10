package pl.training.shop.payments;

import pl.training.shop.payments.domain.DefaultPaymentFactory;
import pl.training.shop.payments.ports.IdGenerator;
import pl.training.shop.payments.ports.PaymentFactory;
import pl.training.shop.payments.ports.PaymentRepository;
import pl.training.shop.payments.ports.PaymentService;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class PaymentsConfiguration {

    private static final PaymentFactory PAYMENT_FACTORY = new DefaultPaymentFactory();

    @Singleton
    @Produces
    public PaymentService paymentService(IdGenerator idGenerator, PaymentRepository paymentRepository) {
        return PAYMENT_FACTORY.paymentsService(idGenerator, paymentRepository);
    }

}
