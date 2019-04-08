package org.ghxiao.rxjava.observable.aggregate;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Average {
    public static void main(String[] args) throws InterruptedException {
        final Disposable disposable = Observable
                .interval(1, 1, TimeUnit.SECONDS)
                .take(5)
                .reduce(new Aggregator(0, 0),
                        (a, x) -> new Aggregator(a.sum + x, a.count + 1))
                .map(a -> a.sum / a.count)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

    public static class Aggregator {
        final long sum;
        final long count;

        public Aggregator(long sum, long count) {
            this.sum = sum;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Aggregator{" +
                    "sum=" + sum +
                    ", count=" + count +
                    '}';
        }
    }
}
