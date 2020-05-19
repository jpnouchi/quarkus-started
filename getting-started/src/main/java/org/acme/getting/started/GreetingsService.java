package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;


/**
 * GreetingsService
 */
@ApplicationScoped
public class GreetingsService {

    @ConfigProperty(name = "greetings.message")
    String msg;

    public String toUpperCase(){
        return msg.toUpperCase();
    }
}
