package org.acme.getting.started;

import java.util.HashMap;
import java.util.Map;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

/**
 * HelloWorldQuarkusTestResourcesLifecycleManager
 */
public class HelloWorldQuarkusTestResourcesLifecycleManager implements QuarkusTestResourceLifecycleManager {

    @Override
    public Map<String, String> start() {
        System.out.println("Se van aejecutar los tests");
        Map<String,String>  properties=new HashMap<>();
        properties.put("greetings.message", "Aloha test");
        return properties;
    }

    @Override
    public void stop() {
        System.out.println("Ya se ejecutaron los tests");
    }

    
}