package org.acme.getting.started;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    Logger logger = Logger.getLogger(GreetingResource.class);

    @Inject
    GreetingsService greetingService;

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.toUpperCase();
    }

    @GET
    @Path("/now")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNow() {
        WorldClockHeaders worldClockHeaders = new WorldClockHeaders();
        worldClockHeaders.logger = "DEBUG";
        WorldClock now = worldClockService.getNow(worldClockHeaders);
        logger.debug("Now:"+now);
        return now;
    }

    @GET
    @Path("/nowjaxrs")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNowJaxrs() {
        WorldClock now =ClientBuilder.newClient().target("http://worldclockapi.com")
        .path("/api/json/cet/now")
        .request()
        .get(WorldClock.class);
        logger.debug("NowJaxrs :"+now);
        return now;
    }


    @GET
    @Path("/beer")
    @Produces(MediaType.APPLICATION_JSON)
    public Beer getBeer() {
        logger.debug("Hello from beer log");
        return new Beer("Pilsen","600");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeer(@Valid Beer beer){
        System.out.println(beer);
        return Response.ok().build();            
    }

}