package org.ghxiao.rxjava;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class RxTreeSubscriber {

    public static void main(String[] args) {
        final Flowable<Long> numbers = Flowable.interval(1, 1, TimeUnit.SECONDS);
        numbers.subscribe(x -> System.out.println("number " + x));

        final Flowable<Long> evens = numbers.filter(x -> x % 2 == 0);

        evens.subscribe(x -> System.out.println("even " + x));

        final Flowable<Long> odds = numbers.filter(x -> x % 2 != 0);

        odds.subscribe(x -> System.out.println("odd " + x));


//                .map(RxTreeSubscriber::process)
//                .subscribe(System.out::println,
//                        error -> System.out.println("ERROR " + error));

        sleep(10000);
    }

    public static long process(long n){
        System.out.println("processing " + n);
        if(n == 4) {
            throw new RuntimeException("Something went wrong!" + n);
        }
        return n * 2;
    }

    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
