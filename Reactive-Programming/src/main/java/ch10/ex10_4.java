package ch10;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ex10_4 {

	public static void main(String[] args) throws InterruptedException {

		Observable.range(1, 1000)
		.toFlowable(BackpressureStrategy.BUFFER)
		.subscribeOn(Schedulers.io())
		.subscribe(w -> System.out.println(w + " " + Thread.currentThread().getName()));
		
		
//		Flowable.range(1, 1000)
//		.toObservable()
//		.subscribeOn(Schedulers.io())
//		.subscribe(w -> System.out.println(w + " " + Thread.currentThread().getName()));
//		
		
		
		Thread.sleep(2000);
		
	}

}
