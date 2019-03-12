package org.ghxiao.rxjava.observable.filter;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .sample(3, TimeUnit.SECONDS)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
        Thread.sleep(12000);
    }
}
