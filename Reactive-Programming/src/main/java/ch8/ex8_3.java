package ch8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ex8_3 {
	
	//subscribeOn()

	public static void main(String[] args) throws InterruptedException {
		Observable.just("Pasta","Pizza","Fries","Curry","Chow mein")
				.subscribeOn(Schedulers.computation())
				.map(e -> e.toUpperCase())
				.subscribeOn(Schedulers.newThread())
				.filter(e -> e.startsWith("P"))
				.subscribe(e -> print(e));
		
		Thread.sleep(6000);
		
		
	}
	
	public static void print(String element) throws InterruptedException{
		Thread.sleep(1000);
		System.out.println(element +" : printed by:: "+ Thread.currentThread().getName());
	}
	

}
