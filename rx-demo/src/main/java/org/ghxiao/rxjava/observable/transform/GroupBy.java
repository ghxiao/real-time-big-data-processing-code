package org.ghxiao.rxjava.observable.transform;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupBy {

    public static void main(String[] args) {
        //final Observable<GroupedObservable<Integer, String>> go =
        Observable.fromArray("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven")
                .groupBy(s -> s.length())
                .subscribe(
                        ks -> {
                            //System.out.println(ks.getKey());
                            ks.subscribe(s -> System.out.println(ks.getKey() + " " + s));
                        }
                );
    }
}
