package ConnectableObserable;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;


// i think it seems that radio use it
// hot obserble 
public class ConnectableObjerble {

	public static void main(String[] args) throws InterruptedException {
		
		io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> ob=Observable.interval(1L, TimeUnit.SECONDS).publish();
		
		ob.connect();
		
		ob.subscribe(num -> System.out.println("Frist ::"+num));
		
		Thread.sleep(10000);
		
		ob.subscribe(num -> System.out.println("seconde ::"+num));
		
		Thread.sleep(10000);
		
		
	}

}
