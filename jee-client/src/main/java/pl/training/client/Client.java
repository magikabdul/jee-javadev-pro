package pl.training.client;

import lombok.extern.java.Log;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import pl.training.shop.payments.adapters.rest.PaymentDto;
import pl.training.shop.payments.adapters.rest.PaymentRequestDto;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

@Log
public class Client {

    public static void main(String[] args) {
        var restClient = new ResteasyClientBuilderImpl()
                .register(BinaryMapper.class)
                .build();
        var payments = restClient.target("http://localhost:8080/jee/api/payments");
        var paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setRequestId(1L);
        paymentRequestDto.setValue("200 PLN");
        var response = payments.request()
                //.accept(MediaType.APPLICATION_XML_TYPE)
                .accept(BinaryMapper.MEDIA_TYPE)
                .post(Entity.entity(paymentRequestDto, MediaType.APPLICATION_JSON));
        log.info("### Response: " + response.getStatus());
        log.info("### Body: " + response.readEntity(PaymentDto.class));
    }

}
