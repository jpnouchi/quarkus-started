package org.acme.getting.started;

import javax.ws.rs.HeaderParam;

/**
 * WorldClockHeaders
 */
public class WorldClockHeaders {

    @HeaderParam("X-Logger")
    String logger;
}