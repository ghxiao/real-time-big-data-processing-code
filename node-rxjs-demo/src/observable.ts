import {Observable, Subject} from 'rxjs';

const observable = new Observable(subscriber => {
    subscriber.next(Math.random() );
    subscriber.next(Math.random() );
    subscriber.next(Math.random() );
});

observable.subscribe({
    next: (v) => console.log(`observerA: ${v}`)
});

observable.subscribe({
    next: (v) => console.log(`observerB: ${v}`)
});
