package pl.training.shop.payments.adapters.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.training.shop.commons.Page;
import pl.training.shop.payments.domain.PaymentStatus;
import pl.training.shop.payments.ports.PaymentService;

import java.net.URI;

@Path("payments")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class PaymentController {

    private final PaymentService paymentService;
    private final RestPaymentMapper paymentMapper;
    @Context
    @Setter
    private UriInfo uriInfo;

    @POST
    public Response process(PaymentRequestDto paymentRequestDto) {
        var paymentRequest = paymentMapper.toDomain(paymentRequestDto);
        var payment = paymentService.process(paymentRequest);
        var paymentDto = paymentMapper.toDto(payment);
        return Response.created(getLocation(paymentDto.id))
                .entity(paymentDto)
                .build();
    }

    @GET
    @Path("{id:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}}")
    public Response getById(@PathParam("id") String id) {
        var payment = paymentService.getById(id);
        var paymentDto = paymentMapper.toDto(payment);
        return Response.ok(paymentDto).build();
    }

    @GET
    @Path("confirmed")
    public Response getByStatus(@QueryParam("pageSize") @DefaultValue("5") int pageSize,
                                @QueryParam("pageNumber") @DefaultValue("0") int pageNumber) {
        var page = new Page(pageNumber, pageSize);
        var resultPage = paymentService.getByStatus(PaymentStatus.CONFIRMED, page);
        var resultPageDto = paymentMapper.toDto(resultPage);
        return Response.ok(resultPageDto).build();
    }

    private URI getLocation(String id) {
        return uriInfo.getAbsolutePathBuilder().path(id).build();
    }

}
