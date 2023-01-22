package ex7_2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Cash {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
				.cache();
		
		src.subscribe(e -> System.out.println("옵저버 1:: "+e));
		
		Thread.sleep(5000);
		
		src.subscribe(e -> System.out.println("옵저버 2:: "+e));
		
		
		Thread.sleep(5000);

	}

}
