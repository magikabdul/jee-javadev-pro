package pl.training.shop.payments.adapters;

import lombok.RequiredArgsConstructor;
import pl.training.shop.commons.Page;
import pl.training.shop.commons.Proxy;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.adapters.logging.LogPayments;
import pl.training.shop.payments.domain.Payment;
import pl.training.shop.payments.domain.PaymentRequest;
import pl.training.shop.payments.domain.PaymentStatus;
import pl.training.shop.payments.ports.PaymentService;

import javax.inject.Inject;

@Proxy
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PaymentsServiceProxy implements PaymentService {

    private final PaymentService paymentService;

    @LogPayments
    @Override
    public Payment process(PaymentRequest paymentRequest) {
        return paymentService.process(paymentRequest);
    }

    @Override
    public Payment getById(String id) {
        return paymentService.getById(id);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        return paymentService.getByStatus(status, page);
    }

}
