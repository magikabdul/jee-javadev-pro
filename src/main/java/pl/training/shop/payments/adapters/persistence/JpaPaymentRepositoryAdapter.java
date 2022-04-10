package pl.training.shop.payments.adapters.persistence;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;
import pl.training.shop.payments.domain.Payment;
import pl.training.shop.payments.domain.PaymentStatus;
import pl.training.shop.payments.ports.PaymentRepository;

import java.util.Optional;

@Transactional
@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaPaymentRepositoryAdapter implements PaymentRepository {

    private final JpaPaymentRepository paymentRepository;
    private final JpaPersistencePaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        var entity = paymentMapper.toEntity(payment);
        var persistedEntity = paymentRepository.save(entity);
        return paymentMapper.toDomain(persistedEntity);
    }

    @Override
    public Optional<Payment> getById(String id) {
        return paymentRepository.getById(id)
                .map(paymentMapper::toDomain);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        var result = paymentRepository.getByStatus(status.name(), page);
        var data = result.getData().stream().map(paymentMapper::toDomain).toList();
        return result.with(data);
    }

}
