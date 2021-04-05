package org.ghxiao.rxjava.observable.error;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Retry {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> backup
                = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Object> source = Observable
                .create(emitter -> {
                    emitter.onNext(1L);
                    emitter.onNext(2L);
                    emitter.onError(new RuntimeException("error!"));
                    emitter.onNext(3L);
                    emitter.onNext(4L);
                    emitter.onComplete();
                });

        source
                        .share()
                //.onErrorReturnItem(0L)
                .retry()
                //       .onErrorResumeNext(source)
                .onErrorResumeNext(Observable.empty())
                .subscribe(System.out::println, System.out::println);
        Thread.sleep(20000);
    }
}
