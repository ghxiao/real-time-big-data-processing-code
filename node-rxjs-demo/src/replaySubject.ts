import {ReplaySubject, Subject} from 'rxjs';
const subject = new ReplaySubject(3); // buffer 3 values fo
subject.subscribe({
    next: (v) => console.log(`observerA: ${v}`)
});
subject.next(1);
subject.next(2);
subject.next(3);
subject.next(4);
subject.subscribe({
    next: (v) => console.log(`observerB: ${v}`)
});
