import {Subject} from 'rxjs';

const subject = new Subject<number>();
subject.subscribe({
    next: (v) => console.log(`observerA: ${v}`)
});

subject.subscribe({
    next: (v) => console.log(`observerB: ${v}`)
});

subject.next(Math.random());
subject.next(Math.random());
