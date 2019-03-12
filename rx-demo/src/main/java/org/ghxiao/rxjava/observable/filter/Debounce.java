package org.ghxiao.rxjava.observable.filter;

import io.reactivex.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Debounce {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> feed = Observable.interval(1, 100, TimeUnit.MILLISECONDS)
                .filter(x -> {
//                            System.out.println(x);
                            return new Random(x).nextInt(32) < 10;
                        }
                    );
        //final Observable<Long> shared = feed.share();

        feed.subscribe(x -> System.out.println("S0: " + x));
        feed.debounce(300, TimeUnit.MILLISECONDS).subscribe(x -> System.out.println("DE: " + x));

        Thread.sleep(10000);
    }
}
