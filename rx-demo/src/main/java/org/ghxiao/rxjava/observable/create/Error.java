package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class Error {
    public static void main(String[] args) {
        Observable.error(new RuntimeException("Something Went wronng!"))
                .subscribe(System.out::println,
                        (e) -> System.out.println("ERROR " + e),
                        () -> System.out.println("DONE")
                );
    }
}
