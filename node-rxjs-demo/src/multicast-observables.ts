import {ConnectableObservable, from, Subject} from 'rxjs';
import {multicast} from 'rxjs/operators';

const source = from([1, 2, 3]);
const subject = new Subject();
const multicasted = source.pipe(
    multicast(subject)
) as ConnectableObservable<number>;

// These are, under the hood, `subject.subscribe({...})`:
multicasted.subscribe({
    next: (v) => console.log(`observerA: ${v}`)
});
multicasted.subscribe({
    next: (v) => console.log(`observerB: ${v}`)
});

setTimeout(() => {
//        subscription.unsubscribe();
//        console.log("unsubscribed!")
    },
    10000
);

multicasted.connect();
