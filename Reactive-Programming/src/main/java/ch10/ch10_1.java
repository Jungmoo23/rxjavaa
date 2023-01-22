package ch10;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ch10_1 {

	/*
	 * 1. Backpressure (배압)
	 * 
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable.range(1,1000000)
		.map(e ->{
			System.out.println("Produced item is : e:: "+ e + " : "+Thread.currentThread().getName());
			return e;
		})
		.subscribeOn(Schedulers.io())
		.subscribe(e -> {
			sleep(100L);
			System.out.println("Consumed item is : e:: "+ e + " : "+Thread.currentThread().getName());
		});
		
		sleep(10000000L);

	}

	private static void sleep(Long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
