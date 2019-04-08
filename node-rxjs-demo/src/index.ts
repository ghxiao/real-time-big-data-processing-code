import {interval} from 'rxjs';

const observable = interval(1000);

const subscription = observable.subscribe(
    x => console.log(x));

setTimeout(() => {
        subscription.unsubscribe();
        console.log("unsubscribed!")
    },
    10000
);
