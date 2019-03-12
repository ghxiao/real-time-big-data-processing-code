package org.ghxiao.rxjava.observable.aggregate;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Concat {
    public static void main(String[] args) throws InterruptedException {
        final Observable<String> s1 = Observable
                .interval(1,1, TimeUnit.SECONDS)
                .take(5)
                .map(x -> "a" + x);

        final Observable<String> s2 = Observable
                .interval(0,1, TimeUnit.SECONDS)
                .map(x -> "b" + x);

        Observable.concat(s1, s2).subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
