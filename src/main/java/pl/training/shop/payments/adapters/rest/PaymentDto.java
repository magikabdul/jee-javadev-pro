package pl.training.shop.payments.adapters.rest;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;

@XmlRootElement(name = "payment")
@Data
public class PaymentDto implements Serializable {

    String id;
    String value;
    Instant timestamp;
    String status;

}
