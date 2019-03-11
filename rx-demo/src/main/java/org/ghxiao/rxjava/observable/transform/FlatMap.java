package org.ghxiao.rxjava.observable.transform;

import io.reactivex.Observable;

public class FlatMap {
    public static void main(String[] args) {
        final Observable<Integer> map =
                Observable.fromArray(1, 2, 3)
                .flatMap(i -> Observable.just(i, -i));

        map
                .subscribe(System.out::println,
                (e) -> System.out.println("ERROR " + e),
                () -> System.out.println("DONE")
        );
    }
}
