package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Path("now")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNow(){
        return worldClockService.getNow();
    }
}