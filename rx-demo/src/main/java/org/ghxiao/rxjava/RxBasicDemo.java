package org.ghxiao.rxjava;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class RxBasicDemo {
    public static void main(String[] args) {
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .map(RxBasicDemo::process)
                .subscribe(System.out::println,
                        error -> System.out.println("ERROR " + error));
        sleep(10000);
    }


    public static long process(long n) {
        System.out.println("processing " + n);
        if (n == 4) {
            throw new RuntimeException("Something went wrong!" + n);
        }
        return n * 2;
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
