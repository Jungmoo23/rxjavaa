package ch8;

import io.reactivex.rxjava3.core.Observable;

public class ex8_1 {

	public static void main(String[] args) {
		
		Observable ob = Observable.create(
				e -> {
					new Thread (()
							->
					{
						e.onNext("Hello");
						e.onNext("Rx java");
					}

							) {
						
					}.start();
				}
				);
		
		
		ob.subscribe(s -> System.out.println("옵저버1:: "+s+" Thread name is:: " +Thread.currentThread().getName()));
		ob.subscribe(s -> System.out.println("옵저버2:: "+s+" Thread name is:: " +Thread.currentThread().getName()));
		
		
		
	}

}
