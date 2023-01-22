package ch8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ex8_2Custome_shce {

	public static void main(String[] args)  throws InterruptedException {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		Scheduler src = Schedulers.from(executor);
		
		Observable<Integer>ob = Observable.just(1,2,3,4,5,6,7,8)
				.subscribeOn(Schedulers.computation())
				.doFinally(executor:: shutdown);
		
		ob.subscribe(e -> com());
		//newThread 때문에 삽
//		Thread.sleep(5000);
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		ob.subscribe(e -> com());
		
		Thread.sleep(500000);
		
	}
	
public static void com() throws InterruptedException{
		
		Thread.sleep(1000);
		System.out.println("Thread Time is:: "+Thread.currentThread().getName());
		
	}
	
}
