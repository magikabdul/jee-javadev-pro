package pl.training.shop.payments.adapters.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@NamedQuery(name = PaymentEntity.GET_BY_STATUS, query = "select p from Payment p where p.status = :status")
@NamedQuery(name = PaymentEntity.COUNT_BY_STATUS, query = "select count(p.id) from Payment p where p.status = :status")
@Entity(name = "Payment")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
public class PaymentEntity {

    public static final String GET_BY_STATUS = "paymentGetByStatus";
    public static final String COUNT_BY_STATUS = "paymentCountByStatus";

    @Id
    private String id;
    private BigDecimal value;
    private String currency;
    private Instant timestamp;
    private String status;

}
