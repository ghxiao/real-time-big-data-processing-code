package org.ghxiao.rxjava.observable.aggregate;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Reduce {
    public static void main(String[] args) throws InterruptedException {
         Observable
                .interval(1,1, TimeUnit.SECONDS)
                .take(5)
                .reduce(0L, (x,y)-> x + y)

         // ((0 + 0) + 1) + 2 ...


         .subscribe(System.out::println);

         Thread.sleep(10000);
    }
}
