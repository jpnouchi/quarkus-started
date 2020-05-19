package org.acme.getting.started;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class WorldClockFallBack implements FallbackHandler<WorldClock> {

    @Override
    public WorldClock handle(ExecutionContext context) {
        // TODO Auto-generated method stub
        WorldClock worldClock= new WorldClock();
        worldClock.setCurrentDateTime("NO TIME");
        return worldClock ;
    }

    

}