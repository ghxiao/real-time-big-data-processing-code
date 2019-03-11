package org.ghxiao.rxjava.observable.create;

import io.reactivex.Observable;

public class Create {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onError(new RuntimeException("something went wrong!"));
            emitter.onNext(2);
            emitter.onComplete();
        }).subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
