package org.ghxiao.rxjava.observable.transform;

import io.reactivex.Observable;

public class Scan {
    public static void main(String[] args) {
        Observable.fromArray(1, 2, 3)
                .scan((x, y) -> x + y)
                .subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
