package ch10;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ch10_3 {

	public static void main(String[] args) throws InterruptedException {

		Flowable.create(e -> {
			for(int i=0; i<5000; i++) {
				if(e.isCancelled()) {
					return ; 
				}
				e.onNext(i);
			}
			e.onComplete();
		}, BackpressureStrategy.BUFFER)
		.observeOn(Schedulers.io())
		.subscribe(System.out::println);
		
		Thread.sleep(2000);
		
	}

}
