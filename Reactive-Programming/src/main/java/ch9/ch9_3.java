package ch9;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ch9_3 {

	/*
	 * switchMap
	 * 1. 마지막으로 방출된 관찰 가능 항목만 구독합니까?
	 * 2. 
	 * */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Observable<String> source = Observable.just("John","Lily","Emma","Reyan","Darshin")
				.concatMap(
						s -> Observable.just(s)
						.delay(
								ThreadLocalRandom.current().nextInt(1000),TimeUnit.MILLISECONDS
								));
		
		Observable.interval(2, TimeUnit.SECONDS)
		.switchMap(s -> source.doOnDispose(
				() -> System.out.println("Disposing and starting again!")
				))
		.subscribe(System.out::println);
		
		Thread.sleep(10000);
		
		
	}

}
