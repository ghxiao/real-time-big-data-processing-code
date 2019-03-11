package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class Range {
    public static void main(String[] args) {
        Observable.range(5, 10)
                .subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
