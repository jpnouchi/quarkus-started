package org.acme.getting.started;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@RegisterRestClient
public interface WorldClockService {

    @Path("/json/cet/now")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // @Retry(maxRetries = 3, delay = 3, delayUnit = ChronoUnit.SECONDS)    
    // @Fallback(WorldClockFallBack.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000)
    WorldClock getNow();

}