package org.ghxiao.rxjava.observable.aggregate;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ConcatStrings {
    public static void main(String[] args) throws InterruptedException {
         Observable
                .interval(1, 1, TimeUnit.SECONDS)
                .take(5)
                 .map(String::valueOf)
                .reduce("",
                        (a, x) -> a  + x
                        )
                .subscribe(System.out::println);

         Thread.sleep(10000);
    }


}
