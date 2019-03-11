package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class FromArray {
    public static void main(String[] args) {
        Observable.fromArray(1, 2, 3).subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
