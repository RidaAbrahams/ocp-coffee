package za.co.sb.qp.coffee.boundary;

import lombok.extern.java.Log;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import za.co.sb.qp.coffee.boundary.control.PricingResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("coffee")
@RequestScoped
@Log
public class CoffeeResource {

    @ConfigProperty(name = "coffee.producer", defaultValue = "Nestle")
    String coffeeProducer;
    @Inject
    @RestClient
    PricingResource pricingResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoffeeOfTheDay() {
        return Response.ok(Collections.singletonMap("Coffee of the day", "Ispirazione Napoli")).build();
    }

    @GET
    @Path("/manufacturer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoffeeProducer() {
        return Response.ok(Collections.singletonMap("Manufactured by", coffeeProducer)).build();
    }

    @GET
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoffeeOfTheDayPrice() {
        String coffee = "Ispirazione Napoli";
        String price = pricingResource.getCoffeeOfTheDayPrice();
        return Response.ok(Collections.singletonMap(coffee, price)).build();
    }
}
