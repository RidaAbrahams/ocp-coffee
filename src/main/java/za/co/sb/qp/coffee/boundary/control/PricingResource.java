package za.co.sb.qp.coffee.boundary.control;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/price")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface PricingResource {

    @GET
    String getCoffeeOfTheDayPrice();
}
