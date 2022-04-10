package pl.training.shop.payments.adapters.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.Instant;

@XmlRootElement(name = "payment")
@Data
public class PaymentDto implements Serializable {

    String id;
    String value;
    @JsonIgnore
    Instant timestamp;
    String status;

}
