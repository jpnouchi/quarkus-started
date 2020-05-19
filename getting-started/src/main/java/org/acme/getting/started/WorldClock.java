package org.acme.getting.started;

/**
 * WorldClock
 */
public class WorldClock {

    private String currentDateTime;

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @Override
    public String toString() {
        return "WorldClock [currentDateTime=" + currentDateTime + "]";
    }
    
    
}