package org.acme.getting.started;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> hello() {
        return ReactiveStreams.of("h", "e", "l", "l", "o").map(String::toUpperCase).toList().run()
                .thenApply(list -> list.toString());
    }

    @Inject
    @Channel("my-in-memory")
    Emitter<Integer> emitter;

    @GET
    @Path("/emit/{dato}")
    @Produces(MediaType.APPLICATION_JSON)
    public void emit(@PathParam("dato") Integer dato) {
        emitter.send(dato);
    }

    @Inject
    @Channel("generated-temperature")
    Emitter<Integer> emitterTemperature;

    @GET
    @Path("/temperature/{dato}")
    @Produces(MediaType.APPLICATION_JSON)
    public void temperature(@PathParam("dato") Integer dato) {
        emitterTemperature.send(dato);
    }

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Path("/nowAsync")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<List<WorldClock>> getNow() {
        CompletionStage<WorldClock> cet = worldClockService.getNow("cet");
        return cet.thenCombineAsync(
                worldClockService.getNow("gmt"),
                (cetRs, gmtRs) -> Arrays.asList(cetRs, gmtRs));
    }

}