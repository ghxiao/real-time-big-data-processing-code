package org.ghxiao.rxjava.observable.error;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Catch {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> backup
                = Observable.interval(1, TimeUnit.SECONDS);
        Observable
                .create(emitter -> {
                    emitter.onNext(1L);
                    emitter.onNext(2L);
                    emitter.onError(new RuntimeException("error!"));
                    emitter.onComplete();
                })
                //.onErrorReturnItem(0L)
                .onErrorResumeNext(backup)
                .subscribe(System.out::println, (err) -> System.out.println(err));
        Thread.sleep(20000);
    }
}
