package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

/**
 * ConsumerData
 */
@ApplicationScoped
public class ConsumerData {

    @Incoming("my-in-memory")
    public void printRandom(int randomNumber){
        System.out.println("consumer my-in-memory: "+randomNumber);
    }

    @Incoming("temperature")
    public void printTemperature(int temperature){
        System.out.println("consumer temperature: "+temperature);
    }
}