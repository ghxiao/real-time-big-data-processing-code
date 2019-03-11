package org.ghxiao.rxjava.observable.transform;

import io.reactivex.Observable;

public class Map {
    public static void main(String[] args) {
        Observable.fromArray(1, 2, 3)
                .map(i -> 2 * i)
                .subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
