package ch8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ex8_4 {

	public static void main(String[] args) throws InterruptedException {
		Observable.just("Pasta","Pizza","Fries","Curry","Chow mein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.doOnNext(e -> System.out.println(Thread.currentThread().getName()))
				.observeOn(Schedulers.newThread())
				.filter(e -> e.startsWith("P"))
				.observeOn(Schedulers.io())
				.subscribe(e -> print(e));
		
		Thread.sleep(6000);
		
		
	}
	
	public static void print(String element) throws InterruptedException{
		//Thread.sleep(1000);
		System.out.println(element +" : printed by:: "+ Thread.currentThread().getName());
	}

}
