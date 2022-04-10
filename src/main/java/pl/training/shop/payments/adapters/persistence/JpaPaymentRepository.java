package pl.training.shop.payments.adapters.persistence;

import lombok.Setter;
import pl.training.shop.commons.Page;
import pl.training.shop.commons.ResultPage;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Singleton
public class JpaPaymentRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;

    public PaymentEntity save(PaymentEntity paymentEntity) {
        entityManager.persist(paymentEntity);
        return paymentEntity;
    }

    public Optional<PaymentEntity> getById(String id) {
        return Optional.ofNullable(entityManager.find(PaymentEntity.class, id));
    }

    public ResultPage<PaymentEntity> getByStatus(String status, Page page) {
        var result = entityManager.createNamedQuery(PaymentEntity.GET_BY_STATUS, PaymentEntity.class)
                .setParameter("status", status)
                .setFirstResult(page.getOffset())
                .setMaxResults(page.getSize())
                .getResultList();
        var count = entityManager.createNamedQuery(PaymentEntity.COUNT_BY_STATUS, Long.class)
                .setParameter("status", status)
                .getSingleResult();
        return new ResultPage<>(result, page.getNumber(), (count / page.getSize()) + 1);
    }

}
