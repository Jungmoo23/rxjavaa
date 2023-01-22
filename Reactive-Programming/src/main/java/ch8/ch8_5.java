package ch8;

import java.time.LocalTime;
import java.util.Locale;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ch8_5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Observable.just("Pasta","Pizza","Fries","Curry","Chow mein")
		.flatMap(e -> Observable.just(e)
				.subscribeOn(Schedulers.computation())
				.map(str -> print(str)))
		.subscribe(System.out::println);
		
		
		Thread.sleep(7000);
		

	}
	
	public static String print(String element) throws InterruptedException{
		//Thread.sleep(1000);
		String s = element +" : printed by:: "+ Thread.currentThread().getName()
				+ " at:: "+ LocalTime.now();
		return s;
			
	}

}
