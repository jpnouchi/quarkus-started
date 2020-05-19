package org.acme.getting.started;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

/**
 * InMemoryConfigSource
 */
public class InMemoryConfigSource implements ConfigSource {

    private Map<String, String> prop = new HashMap<>();

    public InMemoryConfigSource() {
        prop.put("greetings.message", "Memory Hello");
    }

    @Override
    public Map<String, String> getProperties() {
        return prop;
    }

    @Override
    public String getValue(String propertyName) {
        return prop.get(propertyName);
    }

    @Override
    public String getName() {
        return "InMemoryConfigSource";
    }

    @Override
    public int getOrdinal() {
        return 1;
    }

}