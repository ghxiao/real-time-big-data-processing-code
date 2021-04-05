package org.ghxiao.rxjava.intro;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class JDKFlowDemo {

    public static void main(String[] args) {
        SubmissionPublisher<Integer> feed = new SubmissionPublisher<>();

        feed.subscribe(new IntegerSubscriber());

        for (int i = 0; i < 10; i++) {
            feed.submit(i);
        }

        sleep(10000);
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    private static class IntegerSubscriber implements Flow.Subscriber<Integer> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            System.out.println(item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            System.out.println("DONE!");
        }
    }
}
