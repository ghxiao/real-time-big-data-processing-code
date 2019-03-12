package org.ghxiao.rxjava.observable.condition;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class All {
    public static void main(String[] args) throws InterruptedException {
        final Single<Boolean> contains = Observable
                .interval(1, TimeUnit.SECONDS)
                .take(5)
                .all(x -> x < 0);

        contains.subscribe((b, throwable) -> {
            System.out.println(b);
        });
        Thread.sleep(10000);
    }
}
