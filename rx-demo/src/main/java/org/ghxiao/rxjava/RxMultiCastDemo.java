package org.ghxiao.rxjava;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class RxMultiCastDemo {
    public static void main(String[] args) {
        final Flowable<Long> numbers = Flowable.interval(1, 1, TimeUnit.SECONDS)
                .share();

        numbers.subscribe(x -> System.out.println("S1 " + x));

        sleep(5000);

        numbers.subscribe(x -> System.out.println("S2 " + x));

        sleep(10000);
    }

    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
