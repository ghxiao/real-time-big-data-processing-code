package org.ghxiao.rxjava.observable.filter;

import io.reactivex.Observable;

public class Last {
    public static void main(String[] args) {
        Observable.fromArray()
                .last(100)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err)
                );
    }
}
