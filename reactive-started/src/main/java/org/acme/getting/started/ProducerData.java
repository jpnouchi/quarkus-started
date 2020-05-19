package org.acme.getting.started;

import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

/**
 * ProducerData
 */
@ApplicationScoped
public class ProducerData {

    Random random = new Random();
    // @Outgoing("my-in-memory")
    public Flowable<Integer> generate(){
        return Flowable.interval(5,TimeUnit.MILLISECONDS)
                .map(tick->random.nextInt(100));
    }

}