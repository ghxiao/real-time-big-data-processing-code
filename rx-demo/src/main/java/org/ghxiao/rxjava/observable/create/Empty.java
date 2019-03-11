package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class Empty {
    public static void main(String[] args) {
        Observable.empty()
                .subscribe(System.out::println,
                        (e) -> System.out.println("ERROR " + e),
                        () -> System.out.println("DONE")
                );
    }
}
