package org.ghxiao.rxjava.observable.filter;

import io.reactivex.Observable;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Throttle {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> feed = Observable
                .interval(1, 200, TimeUnit.MILLISECONDS)
                .filter(x -> new Random().nextInt(32) < 16);

        feed.subscribe(
                x -> System.out.println("feed:      time=" + LocalDateTime.now() + " value=" + x),
                err -> System.out.println("ERROR " + err),
                () -> System.out.println("DONE"));

        final Observable<Long> throttle = feed.throttleWithTimeout(500, TimeUnit.MILLISECONDS);
        throttle.subscribe(x -> System.out.println("throttled: time=" + LocalDateTime.now() + " value=" + x),
                err -> System.out.println("ERROR " + err),
                () -> System.out.println("DONE"));
        Thread.sleep(10000);
    }
}
