package org.ghxiao.rxjava.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class ObservableDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(4)
                .map(
                        (v) -> {
                            if (v == 2) {
                                throw new RuntimeException("I hate 2!");
                            }
                            return v;
                        }

                )
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // do nothing
                    }

                    @Override
                    public void onNext(Long v) {
                        System.out.println(v);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("ERROR " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("DONE");
                    }
                });

        Thread.sleep(5000);
    }
}
