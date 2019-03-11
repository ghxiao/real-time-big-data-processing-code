package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class Never {
    public static void main(String[] args) {
        Observable.never()
                .subscribe(System.out::println,
                        (e) -> System.out.println("ERROR " + e),
                        () -> System.out.println("DONE")
                );
    }
}
