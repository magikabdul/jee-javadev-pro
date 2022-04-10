package pl.training.shop.payments.ports;

public interface PaymentFactory {

    PaymentService paymentsService(IdGenerator idGenerator, PaymentRepository paymentRepository);

}
